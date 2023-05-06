package com.wangguangwu.keepknowing.util;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.wangguangwu.keepknowing.constant.CommonConstant;
import com.wangguangwu.keepknowing.exception.CommonException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wangguangwu
 */
public final class HttpConnectionUtil {

    private HttpConnectionUtil() {
    }

    public static String get(String url) throws CommonException {
        try (HttpResponse response = HttpUtil.createGet(url).execute()) {
            checkStatusCode(response.getStatus());
            return response.body();
        }
    }

    public static HttpURLConnection getConnection(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        try {
            checkStatusCode(connection.getResponseCode());
        } catch (CommonException e) {
            return null;
        }
        return connection;
    }

    private static void checkStatusCode(int statusCode) throws CommonException {
        CommonAssertions.assertTrue(statusCode / CommonConstant.ONE_HUNDRED == 2, String.format("响应状态状态码不以 2 开头，statusCode：[%d]", statusCode));
    }
}
