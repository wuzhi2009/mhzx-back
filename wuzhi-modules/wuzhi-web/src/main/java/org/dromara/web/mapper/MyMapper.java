package org.dromara.web.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.dromara.web.domain.MhzxGongGao;

import com.github.pagehelper.Page;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MyMapper
 * @description 公告数据库
 * @date 2024年10月13日 12:08:41
 */
public interface MyMapper {

    /**
     * 功能描述: 获取所有公告
     *
     * @param createTime 该时间之后的公告 若不传则显示全部
     * @param id id
     * @return Page<MhzxGongGao>
     * @date 2024年10月13日 12:15:50
     */    
    Page<MhzxGongGao> getList(@Param("createTime") Date createTime, @Param("id") Integer id);

    /**
     * 功能描述: 发布公告
     *
     * @param mhzxGongGao mhzxGongGao
     * @date 2024年10月25日 00:07:48
     */    
    void faBuGongGao(@Param("gongGao") MhzxGongGao mhzxGongGao);

}
