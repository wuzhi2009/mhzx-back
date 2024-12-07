package org.dromara.web.service;


import org.dromara.web.domain.MhzxFund;

import com.github.pagehelper.Page;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className FundService
 * @description 寻访攻略接口
 * @date 2024年09月18日 23:58:35
 */
public interface FundService {
    
    /**
     * 功能描述: 获取寻访攻略列表
     *
     * @param flag 标志
     * @param page 第几页
     * @param pageSize 每页几行数据
     * @param search 搜索值
     * @return List<MhzxFund>
     * @date 2024年09月19日 00:08:55
     */    
    Page<MhzxFund> list(Integer flag, Integer page, Integer pageSize, String search);

    /**
     * 功能描述: 获取中秋灯谜
     *
     * @param search 搜索值
     * @return Page<MhzxFund>
     * @date 2024年10月07日 00:54:40
     */    
    Page<MhzxFund> zhongQiuDengMi(String search);
}
