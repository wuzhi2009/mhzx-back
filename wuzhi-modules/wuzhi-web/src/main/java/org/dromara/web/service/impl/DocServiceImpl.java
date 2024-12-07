package org.dromara.web.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.MessageUtils;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.common.websocket.dto.WebSocketMessageDto;
import org.dromara.common.websocket.utils.WebSocketUtils;
import org.dromara.web.domain.MhzxDoc;
import org.dromara.web.domain.MhzxDocHistory;
import org.dromara.web.domain.MhzxKeJu;
import org.dromara.web.domain.MhzxMenu;
import org.dromara.web.domain.UserHistoryCount;
import org.dromara.web.domain.vo.DocListVo;
import org.dromara.web.mapper.DocMapper;
import org.dromara.web.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className DocServiceImpl
 * @description 获取文章接口实现
 * @date 2024年10月03日 14:53:42
 */
@Slf4j
@Service
public class DocServiceImpl implements DocService {

    /**
     * 用户访问模块数量少于此数时 推荐的列表完全随机
     */
    private static final Integer HISTORY_COUNT = 3;

    @Autowired
    private DocMapper docMapper;
    
    @Override
    public MhzxDoc getDoc(Integer id) {
        // TODO Auto-generated method stub
        MhzxDoc docById = docMapper.getDocById(id);
        // 先判断文章是否存在和公开
        if (ObjectUtil.isEmpty(docById) || docById.getFlag() == MhzxConstant.DOC_CLOSE) {
            return new MhzxDoc();
        }
        return docById;
    }

    @Override
    public void addHistroy(List<MhzxDocHistory> mhzxDocHistorys, Integer type) {
        // TODO Auto-generated method stub
        // 先进行更新操作 如果用户没有看过该文章再进行新增操作
        int updateHistory = docMapper.updateHistory(mhzxDocHistorys, type, mhzxDocHistorys.get(0).getCreateBy(), mhzxDocHistorys.get(0).getUpdateTime());
        if (updateHistory == 0) {
            int count = docMapper.addHistory(mhzxDocHistorys, type);
            if (count <= 0) {
                log.info("【访问记录】增加数据出现错误，参数：{}", mhzxDocHistorys.toString());
            } 
        }
        WebSocketMessageDto webSocketMessageDto = new WebSocketMessageDto();
        webSocketMessageDto.setSessionKeys(List.of(mhzxDocHistorys.get(0).getCreateBy()));
        webSocketMessageDto.setMessage(MessageUtils.message("mhzx.gonggao.get.count"));
        WebSocketUtils.publishMessage(webSocketMessageDto);
    }

    @Override
    public List<DocListVo> list(boolean isLogin) {
        // TODO Auto-generated method stub
        List<DocListVo> docListVos = new ArrayList<>();
        // 获取全部的文章
        List<MhzxDoc> list = docMapper.list();
        if (list.size() <= MhzxConstant.DOC_LIST_NUM) {
            return MapstructUtils.convert(list, DocListVo.class);
        }
        if (!isLogin) {
            // 没有登录的用户直接随机获取
            return rList(list, MhzxConstant.DOC_LIST_NUM);
        } else {
            // 用户已经登录 查看用户比较喜欢访问的模块
            Long userId = LoginHelper.getUserId();
            List<UserHistoryCount> count = docMapper.count(userId);
            if (count.size() <= HISTORY_COUNT) {
                // 新用户无访问模块较少 随机获取
                return rList(list, MhzxConstant.DOC_LIST_NUM);
            }
            // 由高至低排序
            count = StreamUtils.sorted(count, Comparator.comparingLong(UserHistoryCount::getCount).reversed());
            // 权重 7:2:1
            List<Integer> weight = ListUtil.toList(1, 1, 1, 1, 1, 1, 1, 2, 2, 3);
            while (docListVos.size() < MhzxConstant.DOC_LIST_NUM) {
                Random random = new Random(10);
                // 按照比重取前三模块推荐
                UserHistoryCount userHistoryCount = count.get(weight.get(random.nextInt()));
                List<MhzxDoc> doc = StreamUtils.filter(list, item -> item.getMenuId() == userHistoryCount.getModId());
                DocListVo docListVo = rList(doc, 1).get(0);
                docListVos.add(docListVo);
            }
        }
        return docListVos;
    }

    /**
     * 功能描述: 随机获取文章
     *
     * @param list 文章总list
     * @param size 数量
     * @return List<DocListVo>
     * @date 2024年10月03日 18:27:30
     */    
    public List<DocListVo> rList(List<MhzxDoc> list, Integer size) {
        Collections.shuffle(list);
        List<MhzxDoc> subList = list.subList(0, size);
        return MapstructUtils.convert(subList, DocListVo.class);
    }

    @Override
    public List<String> getBreadcrumbByPath(String path) {
        // TODO Auto-generated method stub
        MhzxMenu menuInfoByPath = docMapper.getMenuInfoByPath(path);
        if (ObjectUtil.isEmpty(menuInfoByPath)) {
            // 返回null避免存到redis
            return null;
        }
        List<String> list = new ArrayList<>(4);
        list.add("首页");
        list.add(menuInfoByPath.getTitleName());
        list.add(menuInfoByPath.getText());
        return list;
    }

    @Override
    public List<MhzxKeJu> getKeJuTiMu(String title, Integer flag) {
        // TODO Auto-generated method stub
        List<MhzxKeJu> keJuTiMu = docMapper.getKeJuTiMu(title, flag);
        if (CollectionUtil.isEmpty(keJuTiMu)) {
            // 没有查到相应的题目
            MhzxKeJu mhzxKeJu = new MhzxKeJu();
            mhzxKeJu.setTitle(MessageUtils.message("mhzx.keju.notFund.title"));
            mhzxKeJu.setContent(MessageUtils.message("mhzx.keju.notFund.content"));
            return List.of(mhzxKeJu);
        }
        return keJuTiMu;
    }
}
