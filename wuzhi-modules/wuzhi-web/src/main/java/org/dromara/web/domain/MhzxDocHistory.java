package org.dromara.web.domain;

import java.util.Date;


import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxDocHistory
 * @description 用户访问历史记录表
 * @date 2024年10月03日 17:11:30
 */
@Data
public class MhzxDocHistory {
    
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
     * 文章id
     */
    private Integer docId;

    /**
     * 是否为文章 1 文章 0 公告
     */
    private Integer docFlag;
}
