package org.dromara.job.processors;

import java.util.List;

import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.core.utils.LunarUtil;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.json.utils.JsonUtils;
import org.dromara.common.websocket.utils.WebSocketUtils;
import org.dromara.web.domain.JieRi;
import org.dromara.web.domain.MhzxGongGao;
import org.dromara.web.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className SendGongGaoProcessor
 * @description 发送公告任务
 * @date 2024年10月13日 21:17:54
 */
@Component
public class SendGongGaoProcessor implements BasicProcessor {

    @Autowired
    private MyMapper myMapper;

    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        // TODO Auto-generated method stub
        String jobParams = context.getJobParams();
        List<JieRi> jieRis = JsonUtils.parseArray(jobParams, JieRi.class);
        // 获取今天的新历
        String dateTimeNow = DateUtils.dateTimeNow("MM月dd日");
        // 获取今天的农历 MM月dd
        String byDateResultNongLi = LunarUtil.byDateResultNongLi(DateUtils.getNowDate());
        String jieRiName = new String();
        String huoDongTitle = new String();
        String huoDongContent = new String();
        for (JieRi jieRi : jieRis) {
            if (StringUtils.equalsAny(jieRi.getTime(), dateTimeNow, byDateResultNongLi)) {
                // 不论是农历还是新历都应该匹配上
                jieRiName = jieRi.getType();
                huoDongTitle = jieRi.getTitle();
                huoDongContent = jieRi.getContent();
                break;
            }
        }
        if (StringUtils.isAllBlank(jieRiName, huoDongTitle, huoDongContent)) {
            return new ProcessResult(false, "今天并非节日 无需提醒");
        }
        WebSocketUtils.publishAll(StringUtils.format("{\"code\": 200, \"msg\": { \"title\": \"{}\", \"content\": \"{}\", \"type\": \"{}\" }}", huoDongTitle, huoDongContent, jieRiName));
        // 往数据库中插入公告信息
        MhzxGongGao mhzxGongGao = new MhzxGongGao();
        mhzxGongGao.setCreateTime(DateUtils.getNowDate());
        mhzxGongGao.setTitle(huoDongTitle);
        mhzxGongGao.setContent(huoDongContent);
        mhzxGongGao.setType(MhzxConstant.GONG_GAO_TYPE_JIE_RI);
        myMapper.faBuGongGao(mhzxGongGao);
        return new ProcessResult(true, StringUtils.format("节日：{}，活动：{}，发布公告成功！！", jieRiName, huoDongTitle));
    }
    
}
