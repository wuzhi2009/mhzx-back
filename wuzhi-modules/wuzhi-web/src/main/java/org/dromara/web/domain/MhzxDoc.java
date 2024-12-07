package org.dromara.web.domain;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxDoc
 * @description 文章实体类
 * @date 2024年10月03日 14:57:58
 */
@Data
public class MhzxDoc {
    
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
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 是否可访问 1 可访问 0 不可访问
     */
    private Integer flag;

    /**
     * 文章所属模块id
     */
    private Integer menuId;

    private String nickName;
}
