package com.wangguangwu.keepknowing.client;

import com.wangguangwu.keepknowing.context.RequestContext;
import com.wangguangwu.keepknowing.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 模拟客户端，用于访问新浪微博网站并获取相关页面的内容
 *
 * @author wangguangwu
 */
@Component
@Slf4j
public class WeiboClient {

    @Resource
    private CookieFetcher cookieFetcher;

    /**
     * 访问 url
     *
     * @param url url
     * @return content
     */
    public String get(String url) {
        // 请求 id
        String requestId = RequestContext.getRequestId();
        if (StringUtils.isBlank(url)) {
            log.info("[{}]请求 url 为空", requestId);
            return "";
        }
        // 获取 cookie
        String cookie = cookieFetcher.getCookie();
        // 重试次数
        int retryTimes = 3;
        String content = "";
        for (int i = 0; i < retryTimes; i++) {
            // 填充请求头
            Map<String, String> headers = new HashMap<>(3);
            headers.put(HttpHeaders.ACCEPT, "*/*");
            headers.put(HttpHeaders.HOST, "weibo.com");
            headers.put(HttpHeaders.COOKIE, cookie);
            headers.put("Upgrade-Insecure-Requests", "1");

            content = HttpClientUtil.getWithHeaders(url, headers);

            // 解析数据
            if (StringUtils.isNotBlank(content)) {
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 重置 cookie
            cookie = cookieReset();
        }
        return content;
    }

    /**
     * 重置 cookie
     */
    public String cookieReset() {
        return cookieFetcher.getCookie();
    }

    /**
     * 访问 url
     *
     * @param url   url
     * @param refer 从哪个 url 转发过来
     * @return body 请求体
     */
    public String post(String url, String refer, Map<String, String> body) {
        if (StringUtils.isBlank(url)) {
            return "";
        }
        // 获取 cookie
        String cookie = cookieFetcher.getCookie();
        // 请求头
        // 填充请求头
        Map<String, String> headers = new HashMap<>(3);
        headers.put(HttpHeaders.ACCEPT, "*/*");
        headers.put(HttpHeaders.HOST, "weibo.com");
        headers.put(HttpHeaders.COOKIE, cookie);
        headers.put(HttpHeaders.REFERER, refer);
        return HttpClientUtil.post(url, headers, body);
    }
}
