package org.dromara.web.domain;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className JieRi
 * @description 定时任务 反序列化节日活动提醒实体类
 * @date 2024年10月24日 22:51:45
 */
@Data
public class JieRi {
    
    /**
     * 类型 如 中秋
     */    
    private String type;

    /**
     * MM月dd日 时间 新历农历都一样 如 中秋节 八月十五 元旦节 一月一日 春节 一月初一
     */
    private String time;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
}
