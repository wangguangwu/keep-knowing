package com.wangguangwu.keepknowing.constant;

/**
 * @author wangguangwu
 */
public final class Regex {

    /**
     * 判断 url 是否有 video
     */
    public static final String WEIBO_VIDEO_PATTERN = "[a-zA-z]+://video[^\\s]*";

    /**
     * 微博重定向链接
     */
    public static final String WEIBO_REDIRECT_URL = "<a href=\"(.*?)\"";

    private Regex() {
    }
}
