package org.dromara.web.controller;

import java.util.List;

import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.utils.MessageUtils;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.common.websocket.dto.WebSocketMessageDto;
import org.dromara.common.websocket.utils.WebSocketUtils;
import org.dromara.system.domain.vo.SysUserVo;
import org.dromara.system.service.ISysUserService;
import org.dromara.web.domain.vo.GongGaoVo;
import org.dromara.web.service.MyService;
import org.dromara.web.utils.HistoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cn.hutool.core.util.ObjectUtil;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MyController
 * @description 个人中心对外接口
 * @date 2024年10月13日 12:06:54
 */
@RestController
@RequestMapping("/my")
public class MyController {
    
    @Autowired
    private MyService myService;

    @Autowired
    private ISysUserService iSysUserService;

    /**
     * 功能描述: 获取未读公告数量
     *
     * @return R<Integer>
     * @date 2024年10月13日 12:11:22
     */    
    @GetMapping("/count")
    public R<Integer> weiDuGongGaoCount() {
        boolean login = LoginHelper.isLogin();
        if (!login) {
            return R.ok(0);
        }
        Long userId = LoginHelper.getUserId();
        SysUserVo selectUserById = iSysUserService.selectUserById(userId);
        Integer weiDuGongGaoCount = myService.weiDuGongGaoCount(userId, selectUserById.getCreateTime());
        return R.ok(weiDuGongGaoCount);
    }

    @GetMapping("/getGongGao")
    public R<List<GongGaoVo>> getGongGao(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        boolean login = LoginHelper.isLogin();
        if (!login) {
            return R.fail("您没有登录，无法获取公告信息！！");
        }
        Long userId = LoginHelper.getUserId();
        SysUserVo selectUserById = iSysUserService.selectUserById(userId);
        Page<GongGaoVo> gongGao = myService.getGongGao(userId, selectUserById.getCreateTime(), page, pageSize);
        return R.pageOk(gongGao, gongGao.getTotal());
    }

    /**
     * 功能描述: 获取公告详情
     *
     * @param id id
     * @return R<GongGaoVo>
     * @date 2024年10月13日 13:28:01
     */    
    @GetMapping("/gongGao/{id}")
    @RepeatSubmit(interval = 1200)
    public R<GongGaoVo> gongGao(@PathVariable(name = "id") Integer id) {
        GongGaoVo gongGao = myService.gongGao(id);
        if (ObjectUtil.isNotNull(gongGao.getId())) {
            // 同时将其记录访问历史
            HistoryUtil.updateOrAddDoc(List.of(id), MhzxConstant.HISTORY_GONG_GAO);
        }
        return R.ok(gongGao);
    }

    @GetMapping("/all-yi-du")
    @RepeatSubmit(interval = 60000)
    public R<String> allYiDu() {
        Long userId = LoginHelper.getUserId();
        SysUserVo selectUserById = iSysUserService.selectUserById(userId);
        // 获取全部用户能看到的未读公告id
        Page<GongGaoVo> gongGao = myService.getGongGao(userId, selectUserById.getCreateTime(), null, null);
        List<GongGaoVo> weiDuGongGao = StreamUtils.filter(gongGao, item -> StringUtils.equals(item.getSehenFlag(), MhzxConstant.GONG_GAO_WEI_DU));
        if (weiDuGongGao.size() == 0) {
            return R.ok("设置成功！！");
        }
        List<Integer> ids = StreamUtils.toList(weiDuGongGao, GongGaoVo::getId);
        // 对id进行访问记录操作
        HistoryUtil.updateOrAddDoc(ids, MhzxConstant.HISTORY_GONG_GAO);
        // 告诉前端重新获取未读数量
        WebSocketMessageDto webSocketMessageDto = new WebSocketMessageDto();
        webSocketMessageDto.setSessionKeys(List.of(userId));
        webSocketMessageDto.setMessage(MessageUtils.message("mhzx.gonggao.get.count"));
        WebSocketUtils.publishMessage(webSocketMessageDto);
        // 设为全部已读
        return R.ok("设置成功！！");
    }
}
