package org.dromara.web.domain;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxMenu
 * @description 菜单实体类
 * @date 2024年09月21日 23:56:25
 */
@Data
public class MhzxMenu {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 创建时间
     */    
    private Date createTime;

    /**
     * 创建人
     */    
    private Integer createBy;

    /**
     * 更新时间
     */    
    private Date updateTime;

    /**
     * 更新人
     */    
    private Integer updateBy;

    /**
     * 左侧图标地址
     */
    private String iconUrl;

    /**
     * 右侧文字
     */
    private String text;

    /**
     * 路由地址
     */
    private String url;

    /**
     * 分组id
     */
    private Integer titleId;

    /**
     * 分组名
     */
    private String titleName;
}
