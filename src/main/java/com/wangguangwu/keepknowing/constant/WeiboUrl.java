package com.wangguangwu.keepknowing.constant;

/**
 * Weibo url.
 *
 * @author wangguangwu
 */
public final class WeiboUrl {

    /**
     * 微博查询框的 url
     */
    public static final String WEIBO_SEARCH_BASE_URL = "https://m.weibo.cn/api/container/getIndex?containerid=100103type%3D1%26q%3Dname&page_type=searchall";

    /**
     * 微博搜索 blog
     */
    public static final String WEIBO_BLOG_URL = "https://weibo.com/ajax/statuses/mymblog?uid=searchId&page=searchPage&feature=0";

    /**
     * 微博原图
     * <p>
     * 如果想要调整大小，可以将 `large` 更换为 `bmiddle`、`thumbnail` 或 `org360`
     */
    public static final String WEIBO_JPG_BASE_URL = "https://wx2.sinaimg.cn/large/replace.jpg";

    public static final String WEIBO_VIDEO_VISIT_URL = "https://weibo.com/tv/api/component";

    public static final String WEIBO_VIDEO_REFER_URL = "https://weibo.com/tv/show/fid?from=old_pc_videoshow";

    private WeiboUrl() {
    }
}
