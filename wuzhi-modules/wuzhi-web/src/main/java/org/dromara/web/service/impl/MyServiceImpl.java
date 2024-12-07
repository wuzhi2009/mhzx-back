package org.dromara.web.service.impl;

import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.web.domain.MhzxDocHistory;
import org.dromara.web.domain.MhzxGongGao;
import org.dromara.web.domain.vo.GongGaoVo;

import java.util.Date;
import java.util.List;

import org.dromara.web.mapper.DocMapper;
import org.dromara.web.mapper.MyMapper;
import org.dromara.web.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.hutool.core.collection.CollUtil;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MyServiceImpl
 * @description 个人中心接口实现类
 * @date 2024年10月13日 12:08:15
 */
@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyMapper myMapper;

    @Autowired
    private DocMapper docMapper;
    
    @Override
    public Integer weiDuGongGaoCount(Long userId, Date createTime) {
        // TODO Auto-generated method stub
        // 所有公告
        List<MhzxGongGao> list = myMapper.getList(createTime, null);
        List<Integer> gongGaoIds = StreamUtils.toList(list, MhzxGongGao::getId);
        // 用户的访问记录
        List<MhzxDocHistory> historyByUserId = docMapper.getHistoryByUserId(userId);
        // 未读数量
        Integer weiDu = list.size();
        if (CollUtil.isEmpty(historyByUserId)) {
            // 用户没有访问记录 直接返回
            return weiDu;
        }
        // 筛选用户没访问过的公告
        for (MhzxDocHistory mhzxDocHistory : historyByUserId) {
            if (mhzxDocHistory.getDocFlag() == MhzxConstant.HISTORY_DOC) {
                continue;
            }
            if (gongGaoIds.contains(mhzxDocHistory.getDocId())) {
                weiDu = weiDu - 1;
            }
        }
        return weiDu;
    }

    @Override
    public Page<GongGaoVo> getGongGao(Long userId, Date createTime, Integer page, Integer pageSize) {
        // TODO Auto-generated method stub
        if (page != null || pageSize != null) {
            PageHelper.startPage(page, pageSize);
        }
        // 获取所有公告
        Page<MhzxGongGao> list = myMapper.getList(createTime, null);
        // 用户的访问记录
        List<MhzxDocHistory> historyByUserId = docMapper.getHistoryByUserId(userId);
        // 访问的公告历史记录
        List<MhzxDocHistory> gongGaoHistory = StreamUtils.filter(historyByUserId, item -> item.getDocFlag() == MhzxConstant.HISTORY_GONG_GAO);
        // 用户访问过的公告id
        List<Integer> docIds = StreamUtils.toList(gongGaoHistory, MhzxDocHistory::getDocId);
        Page<GongGaoVo> gongGaoVos = new Page<>();
        for (MhzxGongGao mhzxGongGao : list) {
            GongGaoVo gongGaoVo = new GongGaoVo();
            gongGaoVo.setId(mhzxGongGao.getId());
            gongGaoVo.setTitle(mhzxGongGao.getTitle());
            gongGaoVo.setType(mhzxGongGao.getType());
            gongGaoVo.setCreateTime(mhzxGongGao.getCreateTime());
            gongGaoVo.setContent(mhzxGongGao.getContent());
            gongGaoVo.setName(mhzxGongGao.getName());
            if (docIds.contains(mhzxGongGao.getId())) {
                // 用户已读该公告
                gongGaoVo.setSehenFlag(MhzxConstant.GONG_GAO_YI_DU);
            } else {
                gongGaoVo.setSehenFlag(MhzxConstant.GONG_GAO_WEI_DU);
            }
            gongGaoVos.add(gongGaoVo);
        }
        gongGaoVos.setTotal(list.getTotal());
        return gongGaoVos;
    }

    @Override
    public GongGaoVo gongGao(Integer id) {
        // TODO Auto-generated method stub
        Page<MhzxGongGao> list = myMapper.getList(null, id);
        if (list.size() <= 0 ) {
            GongGaoVo gongGaoVo = new GongGaoVo();
            gongGaoVo.setTitle("不存在该公告！！");
            gongGaoVo.setContent("该公告不存在或已被删除！！");
            return gongGaoVo;
        }
        GongGaoVo convert = MapstructUtils.convert(list.get(0), GongGaoVo.class);
        return convert;
    }
}
