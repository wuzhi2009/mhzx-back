package org.dromara.web.domain.vo;

import org.dromara.web.domain.MhzxDoc;

import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className DocListVo
 * @description 文章列表返回列
 * @date 2024年10月03日 17:37:07
 */
@Data
@AutoMapper(target = MhzxDoc.class)
public class DocListVo {
    
    /**
     * 文章标题
     */    
    private String title;

    /**
     * 文章id
     */
    @AutoMapping(source = "docId", target = "id")
    private Integer docId;

    /**
     * 文章发布时间
     */
}
