package com.wangguangwu.keepknowing.util;

import com.wangguangwu.keepknowing.exception.CommonException;

/**
 * @author wangguangwu
 */
public final class CommonAssertions {

    private CommonAssertions() {
    }

    public static void assertTrue(boolean condition, String message) throws CommonException {
        if (!condition) {
            throw new CommonException(message);
        }
    }
}
