package org.dromara.web.domain.vo;

import java.util.List;

import org.dromara.web.domain.MhzxMenu;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className IndexMenuVo
 * @description 首页列表返回类
 * @date 2024年09月22日 00:10:27
 */
@Data
public class IndexMenuVo {

    /**
     * 所属组
     */
    private String title;

    /**
     * 列表
     */
    private List<MhzxMenu> list;
    
}
