package org.dromara.web.domain.vo;

import java.util.Date;

import org.dromara.web.domain.MhzxGongGao;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className GongGaoVo
 * @description 返回公告类
 * @date 2024年10月13日 12:44:49
 */
@Data
@AutoMapper(target = MhzxGongGao.class)
public class GongGaoVo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 发布类型
     */
    private String type;

    /**
     * 是否已读
     */
    private String sehenFlag;

    /**
     * 公告发布人
     */
    private String name;
}
