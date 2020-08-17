package com.jy.lang;

import java.io.Serializable;

/**
 * @author zhy
 */
public enum BuiltInType {
    /**
     * Integer
     */
    INT_8(Byte.class, false),
    INT_16(Short.class, false),
    INT_32(Integer.class, false),
    INT_64(Integer.class, false),

    /**
     * Unsigned integer
     */
    UINT_8(Byte.class, true),
    UINT_16(Short.class, true),
    UINT_32(Integer.class, true),
    UINT_64(Integer.class, true),

    STRING(String.class, false);

    private Class<? extends Serializable> clz;
    private boolean unsigned;

    BuiltInType(Class<? extends Serializable> clz, Boolean unsigned) {
        this.clz = clz;
        this.unsigned = unsigned;
    }
}
