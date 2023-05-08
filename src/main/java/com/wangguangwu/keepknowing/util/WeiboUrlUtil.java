package com.wangguangwu.keepknowing.util;

import com.wangguangwu.keepknowing.constant.WeiboUrl;

/**
 * @author wangguangwu
 */
public final class WeiboUrlUtil {

    private WeiboUrlUtil() {
    }

    /**
     * 获取微博搜索栏 url
     *
     * @param name 用户姓名
     * @return 搜索栏 url
     */
    public static String getSearchUrl(String name) {
        return WeiboUrl.WEIBO_SEARCH_BASE_URL.replace("name", EncodeUtil.urlEncode(name));
    }

    /**
     * 获取微博 blog url
     * @param uid 用户 id
     * @param searchPage 搜索第几页
     * @return blog url
     */
    public static String getBlogUrl(Long uid, Integer searchPage) {
        return WeiboUrl.WEIBO_BLOG_URL.replace("searchId", String.valueOf(uid)).replace("searchPage", String.valueOf(searchPage));
    }
}
