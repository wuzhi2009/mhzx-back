package org.dromara.web.controller;

import java.util.List;

import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.utils.MessageUtils;
import org.dromara.web.domain.MhzxFund;
import org.dromara.web.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cn.hutool.core.collection.CollectionUtil;


/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className FundController
 * @description 寻访攻略接口
 * @date 2024年09月18日 23:55:32
 */
@RestController
@RequestMapping("/fund")
public class FundController {

    @Autowired
    private FundService fundService;

    /**
     * 功能描述: 获取寻访列表
     *
     * @param flag flag
     * @param page 第几页 不传默认1
     * @param pageSize 每页几条数据 不传默认10
     * @param search 搜索值 不传默认查全部
     * @return R<List<MhzxFund>>
     * @date 2024年09月19日 22:54:24
     */    
    @GetMapping("/list")
    public R<List<MhzxFund>> list(@RequestParam(required = false, name = "flag", defaultValue = "1") Integer flag,
            @RequestParam(required = false, name = "page", defaultValue = "1") Integer page,
            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, name = "search") String search) {
        List<Integer> flags = List.of(MhzxConstant.FUND_JING_CHENG, MhzxConstant.FUND_HE_YANG, MhzxConstant.FUND_DA_WANG_CUN, MhzxConstant.FUND_NAN_JIANG, MhzxConstant.FUND_KONG_SANG_SHAN);
        if (!CollectionUtil.contains(flags, flag)) {
            // 搜索了非寻访的值 进行提示
            return R.fail(MessageUtils.message("mhzx.fund.flag.excetion"));
        }
        Page<MhzxFund> list = fundService.list(flag, page, pageSize, search);
        return R.pageOk(list, list.getTotal());
    }

    /**
     * 功能描述: 华灯烂漫灯谜获取接口
     *
     * @param search search
     * @return R<List<MhzxFund>>
     * @date 2024年10月08日 22:03:03
     */    
    @GetMapping("/zhong-qiu-deng-mi")
    public R<List<MhzxFund>> zhongQiuDengMi(@RequestParam(required = false, name = "search") String search) {
        Page<MhzxFund> zhongQiuDengMi = fundService.zhongQiuDengMi(search);
        return R.pageOk(zhongQiuDengMi, zhongQiuDengMi.getTotal());
    }
}
