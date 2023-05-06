package com.wangguangwu.keepknowing.exception;

/**
 * Weibo 自定义异常.
 *
 * @author wangguangwu
 */
@SuppressWarnings("unused")
public final class WeiboException extends Exception {

    public WeiboException() {

    }

    public WeiboException(String message) {
        super(message);
    }

    public WeiboException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeiboException(Throwable cause) {
        super(cause);
    }

    public WeiboException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
