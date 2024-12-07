package org.dromara.web.service;

import java.util.Date;

import org.dromara.web.domain.vo.GongGaoVo;

import com.github.pagehelper.Page;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MyService
 * @description 个人中心服务接口
 * @date 2024年10月13日 12:07:44
 */
public interface MyService {

    /**
     * 功能描述: 获取未读公告数
     *
     * @param userId 用户id
     * @param createTime 用户创建时间
     * @return Integer
     * @date 2024年10月13日 12:31:26
     */    
    Integer weiDuGongGaoCount(Long userId, Date createTime);

    /**
     * 功能描述: 获取某个时间段之后的所有公告
     *
     * @param userId 用户id
     * @param createTime 开始时间
     * @param page 第几页
     * @param pageSize 每页几条数据
     * @return Page<GongGaoVo>
     * @date 2024年10月13日 12:41:57
     */    
    Page<GongGaoVo> getGongGao(Long userId, Date createTime, Integer page, Integer pageSize);

    /**
     * 功能描述: 获取公告详情
     *
     * @param id id
     * @return GongGaoVo
     * @date 2024年10月13日 13:30:20
     */    
    GongGaoVo gongGao(Integer id);
}
