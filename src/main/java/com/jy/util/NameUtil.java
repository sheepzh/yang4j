package com.jy.util;

/**
 * @author zhy
 */
public class NameUtil {
    /**
     * Transfer java class name to YANG keyword
     *
     * @param javaClz class name in java
     * @return keyword
     */
    public static String java2Yang(Class<?> javaClz) {
        StringBuilder sb = new StringBuilder();
        char[] chars = javaClz.getSimpleName().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                if (i != 0) {
                    sb.append('-');
                }
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
