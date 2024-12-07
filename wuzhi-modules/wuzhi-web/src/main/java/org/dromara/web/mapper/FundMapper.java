package org.dromara.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.dromara.web.domain.MhzxFund;

import com.github.pagehelper.Page;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className FundMapper
 * @description 寻访任务接口
 * @date 2024年09月19日 00:05:11
 */
public interface FundMapper {
    
    /**
     * 功能描述: 根据标识获取寻访任务列表
     *
     * @param flag flag
     * @param search 搜索值
     * @return List<MhzxFund>
     * @date 2024年09月19日 00:00:16
     */    
    Page<MhzxFund> list(@Param("flag") Integer flag, @Param("search") String search);

    /**
     * 功能描述: 获取灯谜
     *
     * @param search 题目搜索
     * @return Page<MhzxFund>
     * @date 2024年10月07日 00:57:26
     */    
    Page<MhzxFund> zhongQiuDengMi(@Param("search") String search);

}
