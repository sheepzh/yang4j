package com.jy.lang.builtin;

import com.jy.SyntaxException;
import com.jy.util.StringUtils;

import java.math.BigDecimal;
import java.util.BitSet;

/**
 * Section 4.2.4
 *
 * @author zhy
 */
@FunctionalInterface
public interface BuiltInType<T> {

    /**
     * Transfer the statement value to java variable
     *
     * @param value the statement value
     * @return the java variable
     * @throws IllegalArgumentException if value is illegal
     */
    T fromArgument(String value) throws IllegalArgumentException;

    /**
     * Wrap the common exception
     *
     * @param typeName name of built-in type
     * @param value    text value of argument
     * @param cause    exception cause
     * @return one illegal argument exception
     */
    static IllegalArgumentException formatException(String typeName, String value, Throwable cause) {
        return new IllegalArgumentException(String.format("'%s' format error: %s", typeName, value), cause);
    }

    // Constants

    /**
     * Any binary data => unsigned long value
     */
    BuiltInType<Long> BINARY = value -> {
        value = value.trim();
        char[] chars = value.toCharArray();
        int length = chars.length;
        if (chars.length > Long.SIZE) {
            throw new NumberFormatException("BINARY is too long: " + length + ", '" + value + "'");
        }
        long result = 0;
        for (char c : chars) {
            if (c != '0' && c != '1') {
                throw formatException("BINARY", value, null);
            }
            result = result << 1 | (c - '0');
        }
        return result;
    };

    /**
     * A set of bits or flags
     */
    BuiltInType<BitSet> BITS = value -> BitSet.valueOf(value.getBytes());

    /**
     * "true" or "false"
     * Case insensitive
     */
    BuiltInType<Boolean> BOOLEAN = value -> {
        if ("true".equals(value)) {
            return Boolean.TRUE;
        } else if ("false".equals(value)) {
            return Boolean.FALSE;
        } else {
            throw formatException("boolean", value, null);
        }
    };

    /**
     * 64-bit signed decimal number
     */
    BuiltInType<BigDecimal> DECIMAL_64 = value -> {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException ne) {
            throw formatException("DECIMAL_64", value, ne);
        }
    };

    /**
     * A leaf that does not have any value
     */
    BuiltInType<Object> EMPTY = value -> {
        if (!StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("EMPTY mustn't have any value: " + value);
        }
        return null;
    };

    /**
     * A reference to an abstract identity
     */
    BuiltInType<String> IDENTITY_REF = value -> value;

    /**
     * Enumerated strings
     * Do nothing
     */
    BuiltInType<String> ENUMERATION = value -> value;

    BuiltInType<Byte> INT8 = value -> {
        try {
            return Byte.valueOf(value);
        } catch (NumberFormatException ne) {
            throw formatException("INT_8", value, ne);
        }
    };

    BuiltInType<Short> INT_16 = value -> {
        try {
            return Short.valueOf(value);
        } catch (NumberFormatException ne) {
            throw formatException("INT_16", value, ne);
        }
    };

    BuiltInType<Integer> INT_32 = value -> {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException ne) {
            throw formatException("INT_32", value, ne);
        }
    };

    BuiltInType<Long> INT_64 = value -> {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException ne) {
            throw formatException("INT_64", value, ne);
        }
    };

    BuiltInType<Short> UINT8 = value -> {
        try {
            short result = Short.parseShort(value);
            if (result > ((short) Byte.MAX_VALUE << 1 | 1) || result < 0)
                throw formatException("UINT_8", value, null);
            return result;
        } catch (NumberFormatException ne) {
            throw formatException("UINT_8", value, ne);
        }
    };

    BuiltInType<Integer> UINT_16 = value -> {
        try {
            int result = Integer.parseInt(value);
            if (result > ((int) Short.MAX_VALUE << 1 | 1) || result < 0)
                throw formatException("UINT_8", value, null);
            return result;
        } catch (NumberFormatException ne) {
            throw formatException("UINT_16", value, ne);
        }
    };

    /**
     * Human-readable string
     */
    BuiltInType<String> STRING = value -> value;
}
