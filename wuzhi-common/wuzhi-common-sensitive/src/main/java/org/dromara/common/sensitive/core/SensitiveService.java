package org.dromara.common.sensitive.core;

/**
 * 脱敏服务
 * 默认管理员不过滤
 * 需自行根据业务重写实现
 *
 * @author wuzhi
 * @version 3.6.0
 */
public interface SensitiveService {

    /**
     * 功能描述: 是否脱敏
     *
     * @param roleKey 参数一
     * @param perms 参数二
     * @return boolean
     * @date 2024年09月26日 22:26:16
     */    
    boolean isSensitive(String roleKey, String perms);

}
