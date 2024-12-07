package org.dromara.web.service.impl;

import org.dromara.web.domain.MhzxFund;
import org.dromara.web.mapper.FundMapper;
import org.dromara.web.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className FundServiceImpl
 * @description 寻访任务攻略实现类
 * @date 2024年09月18日 23:58:20
 */
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundMapper fundMapper;
    
    @Override
    public Page<MhzxFund> list(Integer flag, Integer page, Integer pageSize, String search) {
        PageHelper.startPage(page, pageSize);
        Page<MhzxFund> list = fundMapper.list(flag, search);
        return list;
    }

    @Override
    public Page<MhzxFund> zhongQiuDengMi(String search) {
        // TODO Auto-generated method stub
        Page<MhzxFund> zhongQiuDengMi = fundMapper.zhongQiuDengMi(search);
        return zhongQiuDengMi;
    }
}
