package org.dromara.common.core.constant;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxConstant
 * @description  梦幻诛仙静态变量
 * @date 2024年10月03日 15:41:43
 */
public interface MhzxConstant {

    /**
     * 文章公开
     */
    public static final Integer DOC_OPEN = 1;

    /**
     * 文章不公开
     */
    public static final Integer DOC_CLOSE = 0;

    /**
     * 推荐文章数量
     */
    public static final Integer DOC_LIST_NUM = 8;

    /**
     * 寻访任务 京城寻访
     */
    public static final Integer FUND_JING_CHENG = 1;

    /**
     * 寻访任务 河阳寻访
     */
    public static final Integer FUND_HE_YANG = 2;

    /**
     * 寻访任务 大王村寻访
     */
    public static final Integer FUND_DA_WANG_CUN = 3;

    /**
     * 寻访任务 南疆寻访
     */
    public static final Integer FUND_NAN_JIANG = 4;

    /**
     * 寻访任务 空桑山寻访
     */
    public static final Integer FUND_KONG_SANG_SHAN = 5;

    /**
     * 用户查看历史记录 文章
     */
    public static final Integer HISTORY_DOC = 1;

    /**
     * 用户查看历史记录 公告
     */
    public static final Integer HISTORY_GONG_GAO = 0;

    /**
     * 公告是否已读 已读
     */
    public static final String GONG_GAO_YI_DU = "已读";

    /**
     * 公告是否已读 未读
     */
    public static final String GONG_GAO_WEI_DU = "未读";

    /**
     * 公告类型 节日活动
     */
    public static final String GONG_GAO_TYPE_JIE_RI = "节日活动";

    /**
     * 公告类型 每周活动
     */
    public static final String GONG_GAO_TYPE_MEI_ZHOU = "每周活动";

    /**
     * 公告类型 普通公告
     */
    public static final String GONG_GAO_TYPE_PU_TONG = "普通公告";
}
