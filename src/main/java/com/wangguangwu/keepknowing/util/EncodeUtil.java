package com.wangguangwu.keepknowing.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author wangguangwu
 */
@SuppressWarnings("all")
public final class EncodeUtil {

    private static final String DEFAULT_URL_ENCODING = "UTF-8";

    private EncodeUtil() {
    }

    /**
     * 只对 URL 中的 component 进行编码, Encode 默认 为UTF-8.
     */
    public static String urlEncode(String input) {
        try {
            StringBuilder url = new StringBuilder();
            // 遍历字符串
            for (int i = 0; i < input.length(); i++) {
                char charAt = input.charAt(i);
                // 只对汉字处理
                if (isChineseChar(charAt)) {
                    String encode = URLEncoder.encode(String.valueOf(charAt), DEFAULT_URL_ENCODING);
                    url.append(encode);
                } else {
                    url.append(charAt);
                }
            }
            return url.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported Encoding Exception", e);
        }
    }

    /**
     * 判断汉字的方法,只要编码在 `\u4e00`到 \u9fa5 之间的都是汉字
     *
     * @param c c
     * @return boolean
     */
    public static boolean isChineseChar(char c) {
        return c >= '\u4e00' && c <= '\u9fa5';
    }
}
