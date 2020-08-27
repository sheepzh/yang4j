package com.jy.util;

import com.jy.lang.annotation.AliasFor;

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
        // Check whether alias name has been marked
        AliasFor aliasFor = javaClz.getAnnotation(AliasFor.class);
        if (aliasFor != null) {
            // If marked, return it directly
            return aliasFor.value();
        }
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
