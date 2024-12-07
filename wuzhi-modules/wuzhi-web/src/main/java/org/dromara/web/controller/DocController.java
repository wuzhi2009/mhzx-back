package org.dromara.web.controller;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.dromara.common.core.constant.CacheConstants;
import org.dromara.common.core.constant.Constants;
import org.dromara.common.core.constant.MhzxConstant;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.core.utils.MessageUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.core.utils.file.MimeTypeUtils;
import org.dromara.common.encrypt.annotation.ApiEncrypt;
import org.dromara.common.oss.core.OssClient;
import org.dromara.common.oss.entity.UploadResult;
import org.dromara.common.oss.factory.OssFactory;
import org.dromara.common.ratelimiter.annotation.RateLimiter;
import org.dromara.common.ratelimiter.enums.LimitType;
import org.dromara.common.redis.utils.RedisUtils;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.web.domain.MhzxDoc;
import org.dromara.web.domain.MhzxKeJu;
import org.dromara.web.domain.vo.DocListVo;
import org.dromara.web.mapper.DocMapper;
import org.dromara.web.service.DocService;
import org.dromara.web.utils.HistoryUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ObjectUtil;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className DocController
 * @description 获取文章接口
 * @date 2024年10月03日 14:52:27
 */
@RestController
@RequestMapping("/doc")
public class DocController {
    
    @Autowired
    private DocService docService;

    @Autowired
    private DocMapper docMapper;

    @RateLimiter(time = 60, count = 60, limitType = LimitType.IP)
    @GetMapping("/{docId}")
    public R<MhzxDoc> getDoc(@PathVariable(name = "docId") Integer docId) {
        MhzxDoc mhzxDoc = RedisUtils.getCacheObject(CacheConstants.MHZX_DOC + docId);
        if (ObjectUtil.isNotEmpty(mhzxDoc)) {
            HistoryUtil.updateOrAddDoc(List.of(docId), MhzxConstant.HISTORY_DOC);
            return R.ok(mhzxDoc);
        }
        MhzxDoc doc = docService.getDoc(docId);
        boolean okStatus = doc.getId() != null;
        if (okStatus) {
            RedisUtils.setCacheObject(CacheConstants.MHZX_DOC + docId, doc, Duration.ofMinutes(Constants.MHZX_DOC_TIME));
            HistoryUtil.updateOrAddDoc(List.of(docId), MhzxConstant.HISTORY_DOC);
        }
        return okStatus ? R.ok(doc) : R.neinFund(MessageUtils.message("mhzx.not.doc"));
    }

    @GetMapping("/list")
    public R<List<DocListVo>> list() {
        boolean login = LoginHelper.isLogin();
        List<DocListVo> list = docService.list(login);
        return R.ok(list);
    }

    @GetMapping("/breadcrumb-map")
    public R<List<String>> breadcrumbMap(@RequestParam(name = "path", required = true) String path) {
        List<String> list = RedisUtils.getCacheObject(CacheConstants.MHZX_BREADCRUMB + path);
        if (ObjectUtil.isNotEmpty(list)) {
            return R.ok(list);
        }
        List<String> breadcrumbByPath = docService.getBreadcrumbByPath(path);
        if (ObjectUtil.isEmpty(breadcrumbByPath)) {
            return R.neinFund(MessageUtils.message("mhzx.not.path"));
        }
        RedisUtils.setCacheObject(CacheConstants.MHZX_BREADCRUMB + path, breadcrumbByPath, Duration.ofMinutes(Constants.MHZX_BREADCRUMB));
        return R.ok(breadcrumbByPath);
    }

    @GetMapping("/getkejutimu")
    public R<List<MhzxKeJu>> getKeJuTiMu(@RequestParam(name = "title", required = false) String title,
                            @RequestParam(name = "flag", required = false) Integer flag) {
        if (StringUtils.isBlank(title)) {
            // 没输入标题 不浪费时间去查询
            MhzxKeJu mhzxKeJu = new MhzxKeJu();
            mhzxKeJu.setTitle("请您输入查询内容再进行查询。");
            mhzxKeJu.setContent("输入您要查询的题目");
            return R.ok(List.of(mhzxKeJu));
        }
        List<MhzxKeJu> keJuTiMu = docService.getKeJuTiMu(title, flag);
        return R.ok(keJuTiMu);
    }
    
    /**
     * 临时增加文章的接口
     */
    @ApiEncrypt
    @PostMapping("/add")
    public void add(@RequestBody DocListVo docListVo) throws IOException {
        OssClient storage = OssFactory.instance();
        Document parse = Jsoup.parse(docListVo.getTitle());
        Elements elementsByTag = parse.getElementsByTag("img");
        for (Element element : elementsByTag) {
            String attr = element.attr("src");
            // 将前面一段截掉
            int indexOf = attr.indexOf(",");
            if (indexOf == -1) {
                continue;
            }
            String substring = attr.substring(indexOf);
            element.attr("style", "max-width: 100%");
            byte[] decode = Base64.decode(substring);
            UploadResult uploadSuffix = storage.uploadSuffix(decode, ".png", MimeTypeUtils.IMAGE_PNG);
            element.attr("src", uploadSuffix.getUrl());
        }
        docMapper.add(parse.toString(), DateUtils.getNowDate());
    }

}
