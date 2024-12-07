package org.dromara.web.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxGongGao
 * @description 公告表
 * @date 2024年10月13日 12:05:38
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MhzxGongGao extends BaseEntity {
    
    /**
     * 主键
     */
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 发布类型 如节日活动 每周活动
     */
    private String type;

    /**
     * 发布人名称
     */
    private String name;
}
