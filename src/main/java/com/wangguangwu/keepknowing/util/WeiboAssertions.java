package com.wangguangwu.keepknowing.util;

import com.wangguangwu.keepknowing.exception.WeiboException;

/**
 * @author wangguangwu
 */
@SuppressWarnings("unused")
public final class WeiboAssertions {

    private WeiboAssertions() {
    }

    public static void assertTrue(boolean condition, String message) throws WeiboException {
        if (!condition) {
            throw new WeiboException(message);
        }
    }
}
