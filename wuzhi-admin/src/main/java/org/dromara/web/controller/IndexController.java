package org.dromara.web.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.collection.CollectionUtil;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.dromara.common.core.config.WuzhiConfig;
import org.dromara.common.core.constant.CacheConstants;
import org.dromara.common.core.constant.Constants;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.redis.utils.RedisUtils;
import org.dromara.web.domain.MhzxMenu;
import org.dromara.web.domain.MhzxMenuTitle;
import org.dromara.web.domain.vo.IndexMenuVo;
import org.dromara.web.mapper.MhzxMenuMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author wuzhi
 */
@SaIgnore
@RequiredArgsConstructor
@RestController
public class IndexController {

    /**
     * 系统基础配置
     */
    private final WuzhiConfig wuzhiConfig;

    private final MhzxMenuMapper mhzxMenuMapper;

    /**
     * 访问首页，提示语
     */
    @GetMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", wuzhiConfig.getName(), wuzhiConfig.getVersion());
    }

    @GetMapping("/getMenu")
    public R<List<IndexMenuVo>> getMenu() {
        List<IndexMenuVo> c = RedisUtils.getCacheObject(CacheConstants.MHZX_INDEX_MENU);
        if (CollectionUtil.isNotEmpty(c)) {
            return R.ok(c);
        }
        // 获取所有分组
        List<MhzxMenuTitle> list = mhzxMenuMapper.getList();
        List<Integer> menuIds = StreamUtils.toList(list, MhzxMenuTitle::getId);
        List<MhzxMenu> mhzxMenus = mhzxMenuMapper.getMhzxMenus(menuIds);
        List<IndexMenuVo> indexMenuVos = new LinkedList<>();
        for (MhzxMenuTitle mhzxMenuTitle : list) {
            Integer id = mhzxMenuTitle.getId();
            List<MhzxMenu> dasList = StreamUtils.filter(mhzxMenus, item -> id == item.getTitleId());
            IndexMenuVo indexMenuVo = new IndexMenuVo();
            indexMenuVo.setTitle(mhzxMenuTitle.getTitle());
            indexMenuVo.setList(dasList);
            indexMenuVos.add(indexMenuVo);
        }
        RedisUtils.setCacheObject(CacheConstants.MHZX_INDEX_MENU, indexMenuVos, Duration.ofMinutes(Constants.MHZX_BREADCRUMB));
        return R.ok(indexMenuVos);
    }
}
