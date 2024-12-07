package org.dromara.web.service;

import java.util.List;

import org.dromara.web.domain.MhzxDoc;
import org.dromara.web.domain.MhzxDocHistory;
import org.dromara.web.domain.MhzxKeJu;
import org.dromara.web.domain.vo.DocListVo;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className DocService
 * @description 文章接口
 * @date 2024年10月03日 14:53:05
 */
public interface DocService {
    
    /**
     * 功能描述: 根据id获取文章
     *
     * @param id 文章id
     * @return MhzxDoc
     * @date 2024年10月03日 15:28:54
     */    
    MhzxDoc getDoc(Integer id);

    /**
     * 功能描述: 增加文章查看历史记录
     *
     * @param mhzxDocHistorys mhzxDocHistorys
     * @param type 属于文章还是公告
     * @date 2024年10月03日 17:23:49
     */    
    void addHistroy(List<MhzxDocHistory> mhzxDocHistorys, Integer type);

    /**
     * 功能描述: 获取文章列表
     *
     * @param isLogin 是否登录
     * @return List<DocListVo>
     * @date 2024年10月03日 17:40:54
     */    
    List<DocListVo> list(boolean isLogin);

    /**
     * 功能描述: 根据访问路径获取面包屑
     *
     * @param path path
     * @return List<String>
     * @date 2024年10月05日 01:18:26
     */    
    List<String> getBreadcrumbByPath(String path);

    /**
     * 功能描述: 获取科举题目
     *
     * @param title 搜索的题目
     * @param flag 1 乡试 2 会试 3 殿试
     * @return List<MhzxKeJu>
     * @date 2024年10月06日 01:11:26
     */    
    List<MhzxKeJu> getKeJuTiMu(String title, Integer flag);
}
