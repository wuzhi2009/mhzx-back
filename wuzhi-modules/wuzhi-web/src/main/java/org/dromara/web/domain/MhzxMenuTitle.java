package org.dromara.web.domain;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxMenuTitle
 * @description 分组表实体类
 * @date 2024年09月22日 00:13:47
 */
@Data
public class MhzxMenuTitle {

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
    private Long createBy;

    /**
     * 更新时间
     */    
    private Date updateTime;

    /**
     * 更新人
     */    
    private Long updateBy;

    /**
     * 分组标题
     */
    private String title;
}
