package org.dromara.common.core.constant;

/**
 * 缓存的key 常量
 *
 * @author wuzhi
 */
public interface CacheConstants {

    /**
     * 在线用户 redis key
     */
    String ONLINE_TOKEN_KEY = "online_tokens:";

    /**
     * 参数管理 cache key
     */
    String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    String SYS_DICT_KEY = "sys_dict:";

    /**
     * 梦幻诛仙文章 cache key
     */
    String MHZX_DOC = "mhzx_doc_id:";

    /**
     * 头部面包屑 cache key
     */
    String MHZX_BREADCRUMB = "mhzx_breadcrumb_path:";

    /**
     * 首页菜单缓存 cache key
     */
    String MHZX_INDEX_MENU = "mhzx_index_menu";

}
