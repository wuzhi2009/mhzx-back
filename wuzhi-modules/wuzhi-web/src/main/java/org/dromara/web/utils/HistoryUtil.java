package org.dromara.web.utils;

import java.util.LinkedList;
import java.util.List;

import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.core.utils.SpringUtils;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.web.domain.MhzxDocHistory;
import org.dromara.web.service.DocService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className HistoryUtil
 * @description 历史记录工具类
 * @date 2024年10月13日 13:44:48
 */
@Component
public class HistoryUtil {

    private static final DocService DOC_SERVICE = SpringUtils.getBean(DocService.class);
    
    /**
     * 如果用户登录 记录用户的访问记录
     * @param docId
     * @param type 属于文章还是公告
     */
    @Async
    public static void updateOrAddDoc(List<Integer> docIds, Integer type) {
        boolean login = LoginHelper.isLogin();
        List<MhzxDocHistory> mhzxDocHistories = new LinkedList<>();
        if (login) {
            // 用户是登录状态访问的 访问记录便于推送
            for (Integer docId : docIds) {
                MhzxDocHistory mhzxDocHistory = new MhzxDocHistory();
                mhzxDocHistory.setDocFlag(MhzxConstant.HISTORY_DOC);
                mhzxDocHistory.setCreateBy(LoginHelper.getUserId());
                mhzxDocHistory.setCreateTime(DateUtils.getNowDate());
                mhzxDocHistory.setDocId(docId);
                mhzxDocHistory.setUpdateBy(LoginHelper.getUserId());
                mhzxDocHistory.setUpdateTime(DateUtils.getNowDate());
                mhzxDocHistories.add(mhzxDocHistory);
            }
            DOC_SERVICE.addHistroy(mhzxDocHistories, type);
        }
    }
}
