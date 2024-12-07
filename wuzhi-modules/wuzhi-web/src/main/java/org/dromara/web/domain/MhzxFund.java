package org.dromara.web.domain;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxFund
 * @description 寻访实体
 * @date 2024年09月18日 23:50:29
 */
@Data
public class MhzxFund {

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
     * 寻访人
     */
    private String name;

    /**
     * 地图坐标
     */
    private String address;

    /**
     * 寻访线索
     */
    private String text;

    /**
     * 1 京城寻访 2 河阳寻访 3 大王村寻访 4 南疆寻访 5 空桑山寻访
     */
    private Integer flag;
}
