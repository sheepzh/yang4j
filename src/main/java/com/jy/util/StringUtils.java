package com.jy.util;

/**
 * @author zhy
 */
public class StringUtils {
    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }
}
