package com.wangguangwu.keepknowing.util;

import cn.hutool.core.net.url.UrlQuery;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.wangguangwu.keepknowing.constant.Common;
import com.wangguangwu.keepknowing.exception.HttpStatusException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Http 链接工具类.
 *
 * @author wangguangwu
 */
public final class HttpClientUtil {

    private static final int SUCCESS_PRE = 2;

    private static final int REDIRECT_PRE = 3;

    private HttpClientUtil() {
    }

    public static String getBody(String url) {
        try (HttpResponse response = HttpUtil.createGet(url).execute()) {
            int statusCode = response.getStatus();
            // 重定向
            if (isRedirect(statusCode)) {
                String redirectUrl = RegexUtil.urlRedirect(response.body());
                return getBody(redirectUrl);
            }
            checkStatusCode(statusCode);
            return response.body();
        }
    }

    public static HttpResponse getWithHeaders(String url) {
        return HttpUtil.createGet(url).execute();
    }

    public static String getWithHeaders(String url, Map<String, String> headers) {
        try (HttpResponse response = HttpUtil.createGet(url).addHeaders(headers).execute()) {
            int statusCode = response.getStatus();
            // 重定向
            if (isRedirect(statusCode)) {
                String redirectUrl = RegexUtil.urlRedirect(response.body());
                return getWithHeaders(redirectUrl, headers);
            }
            checkStatusCode(statusCode);
            return response.body();
        }
    }

    public static HttpURLConnection getConnection(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        try {
            checkStatusCode(connection.getResponseCode());
        } catch (HttpStatusException e) {
            return null;
        }
        return connection;
    }

    public static String post(String url, Map<String, String> headers, Map<String, String> bodyMap) {
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        String bodyString = UrlQuery.of(bodyMap).toString();

        try (HttpResponse response = HttpUtil.createPost(url).headerMap(headers, true).body(bodyString).execute()) {
            checkStatusCode(response.getStatus());
            return response.body();
        }
    }

    private static void checkStatusCode(int statusCode) throws HttpStatusException {
        CommonAssertions.assertTrue(statusCode / Common.ONE_HUNDRED == SUCCESS_PRE, String.format("响应状态状态码不以 2 开头，statusCode：[%d]", statusCode));
    }

    private static boolean isRedirect(int statusCode) {
        return statusCode / Common.ONE_HUNDRED == REDIRECT_PRE;
    }
}
