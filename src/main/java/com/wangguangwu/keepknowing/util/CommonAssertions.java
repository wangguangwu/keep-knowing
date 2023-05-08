package com.wangguangwu.keepknowing.util;

import com.wangguangwu.keepknowing.exception.HttpStatusException;

/**
 * @author wangguangwu
 */
public final class CommonAssertions {

    private CommonAssertions() {
    }

    public static void assertTrue(boolean condition, String message) throws HttpStatusException {
        if (!condition) {
            throw new HttpStatusException(message);
        }
    }
}
