package org.dromara.web.domain;

import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className UserHistoryCount
 * @description 用户历史访问记录统计
 * @date 2024年10月03日 18:04:19
 */
@Data
public class UserHistoryCount {
    
    /**
     * 模块id
     */
    private Integer modId;

    /**
     * 访问次数
     */
    private Long count;
}
