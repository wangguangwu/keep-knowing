package com.wangguangwu.keepknowing.exception;

/**
 * 响应状态码不为 2 开头时，即不为直接成功时，抛出的异常
 *
 * @author wangguangwu
 */
@SuppressWarnings("unused")
public class HttpStatusException extends RuntimeException {

    public HttpStatusException() {
    }

    public HttpStatusException(String message) {
        super(message);
    }

    public HttpStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatusException(Throwable cause) {
        super(cause);
    }

    public HttpStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
