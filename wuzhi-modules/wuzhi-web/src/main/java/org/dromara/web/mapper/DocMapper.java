package org.dromara.web.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dromara.web.domain.MhzxDoc;
import org.dromara.web.domain.MhzxDocHistory;
import org.dromara.web.domain.MhzxKeJu;
import org.dromara.web.domain.MhzxMenu;
import org.dromara.web.domain.UserHistoryCount;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className DocMapper
 * @description 文章库接口
 * @date 2024年10月03日 14:54:52
 */
public interface DocMapper {
    
    /**
     * 功能描述: get Doc By Id
     *
     * @param id id
     * @return MhzxDoc
     * @date 2024年10月03日 15:06:16
     */    
    MhzxDoc getDocById(@Param("id") Integer id);

    /**
     * 功能描述: 增加用户访问历史记录
     *
     * @param mhzxDocHistory
     * @param docFlag
     * @return int
     * @date 2024年10月03日 17:26:23
     */    
    int addHistory(@Param("historys") List<MhzxDocHistory> mhzxDocHistory, @Param("docFlag") Integer docFlag);

    /**
     * 功能描述: 更新用户历史记录
     *
     * @param mhzxDocHistory mhzxDocHistory
     * @param docFlag
     * @param createBy
     * @param updateTime
     * @return int
     * @date 2024年10月05日 00:37:13
     */    
    int updateHistory(@Param("historys") List<MhzxDocHistory> mhzxDocHistory, @Param("docFlag") Integer docFlag, @Param("createBy") Long createBy, @Param("updateTime") Date updateTime);

    /**
     * 功能描述: 获取文章列表
     *
     * @return DocListVo
     * @date 2024年10月03日 17:45:08
     */    
    List<MhzxDoc> list();

    /**
     * 功能描述: 用户访问记录统计
     *
     * @param userId 用户id
     * @return List<UserHistoryCount>
     * @date 2024年10月03日 18:06:36
     */    
    List<UserHistoryCount> count(@Param("userId") Long userId);

    /**
     * 功能描述: 获取面包屑信息
     *
     * @param path 路由路径
     * @return MhzxMenu
     * @date 2024年10月05日 01:39:20
     */    
    MhzxMenu getMenuInfoByPath(@Param("path") String path);

    /**
     * 功能描述: 获取科举考试题目
     *
     * @param title 问题
     * @param flag 1 乡试 2 会试 3 殿试 不传则不区分
     * @return List<MhzxKeJu>
     * @date 2024年10月06日 00:03:28
     */    
    List<MhzxKeJu> getKeJuTiMu(@Param("title") String title, @Param("flag") Integer flag);

    /**
     * 功能描述: 根据用户id获取其访问记录
     *
     * @param userId 用户id
     * @return MhzxDocHistory
     * @date 2024年10月13日 12:18:52
     */    
    List<MhzxDocHistory> getHistoryByUserId(@Param("userId") Long userId);

    void add(@Param("content") String content, @Param("time") Date time);
}
