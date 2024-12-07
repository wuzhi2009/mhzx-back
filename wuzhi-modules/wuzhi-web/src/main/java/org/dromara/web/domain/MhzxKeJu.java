package org.dromara.web.domain;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxKeJu
 * @description 梦幻诛仙科举题目表实体类
 * @date 2024年10月05日 23:59:33
 */
@Data
public class MhzxKeJu {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 题目
     */
    private String title;

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
     * 答案
     */
    private String content;

    /**
     * 1乡试 2会试 3殿试
     */
    private Integer flag;
}
