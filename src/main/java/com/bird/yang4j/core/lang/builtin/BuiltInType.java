package com.bird.yang4j.core.lang.builtin;

import com.bird.yang4j.core.lang.annotation.AliasFor;
import com.bird.yang4j.core.util.StringUtils;

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
     * Transfer the statement argument to java variable
     *
     * @param argument the statement argument
     * @return the java variable
     * @throws IllegalArgumentException if argument is illegal
     */
    T fromArgument(String argument) throws IllegalArgumentException;

    /**
     * Wrap the common exception
     *
     * @param typeName name of built-in type
     * @param argument text argument of argument
     * @param cause    exception cause
     * @return one illegal argument exception
     */
    static IllegalArgumentException formatException(String typeName, String argument, Throwable cause) {
        return new IllegalArgumentException(String.format("'%s' format error: %s", typeName, argument), cause);
    }

    // Constants

    /**
     * Any binary data => unsigned long argument
     */
    BuiltInType<Long> BINARY = argument -> {
        argument = argument.trim();
        char[] chars = argument.toCharArray();
        int length = chars.length;
        if (chars.length > Long.SIZE) {
            throw new NumberFormatException("'binary' is too long: " + length + ", '" + argument + "'");
        }
        long result = 0;
        for (char c : chars) {
            if (c != '0' && c != '1') {
                throw formatException("binary", argument, null);
            }
            result = result << 1 | (c - '0');
        }
        return result;
    };

    /**
     * A set of bits or flags
     */
    BuiltInType<BitSet> BITS = argument -> BitSet.valueOf(argument.getBytes());

    /**
     * "true" or "false", case insensitive in section 9.5.1, RFC 6020
     */
    BuiltInType<Boolean> BOOLEAN = argument -> {
        if ("true".equals(argument)) {
            return Boolean.TRUE;
        } else if ("false".equals(argument)) {
            return Boolean.FALSE;
        } else {
            throw formatException("boolean", argument, null);
        }
    };

    /**
     * 64-bit signed decimal number
     */
    BuiltInType<BigDecimal> DECIMAL64 = argument -> {
        try {
            return new BigDecimal(argument);
        } catch (NumberFormatException ne) {
            throw formatException("DECIMAL_64", argument, ne);
        }
    };

    /**
     * A leaf that does not have any argument
     */
    BuiltInType<Object> EMPTY = argument -> {
        if (!StringUtils.isBlank(argument)) {
            throw new IllegalArgumentException("'empty' mustn't have any argument: " + argument);
        }
        return null;
    };

    /**
     * A reference to an abstract identity
     */
    BuiltInType<String> IDENTITYREF = argument -> argument;

    /**
     * Enumerated strings
     * Do nothing
     */
    BuiltInType<String> ENUMERATION = argument -> argument;

    BuiltInType<Byte> INT8 = argument -> {
        try {
            if (argument.startsWith("0")) {
                return Byte.valueOf(argument, 8);
            } else if (argument.startsWith("0x")) {
                return Byte.valueOf(argument, 16);
            } else
                return Byte.valueOf(argument);
        } catch (NumberFormatException ne) {
            throw formatException("INT_8", argument, ne);
        }
    };

    BuiltInType<Short> INT16 = argument -> {
        try {
            return Short.valueOf(argument);
        } catch (NumberFormatException ne) {
            throw formatException("INT_16", argument, ne);
        }
    };

    BuiltInType<Integer> INT32 = argument -> {
        try {
            return Integer.valueOf(argument);
        } catch (NumberFormatException ne) {
            throw formatException("INT_32", argument, ne);
        }
    };

    BuiltInType<Long> INT64 = argument -> {
        try {
            return Long.valueOf(argument);
        } catch (NumberFormatException ne) {
            throw formatException("INT_64", argument, ne);
        }
    };


    // todo all the UINTs need lexers
    // Section 9.2
    BuiltInType<Short> UINT8 = argument -> {
        try {
            short result = Short.parseShort(argument);
            if (result > ((short) Byte.MAX_VALUE << 1 | 1) || result < 0)
                throw formatException("unit8", argument, null);
            return result;
        } catch (NumberFormatException ne) {
            throw formatException("unit8", argument, ne);
        }
    };

    BuiltInType<Integer> UINT16 = argument -> {
        try {
            int result = Integer.parseInt(argument);
            if (result > ((int) Short.MAX_VALUE << 1 | 1) || result < 0)
                throw formatException("UINT_8", argument, null);
            return result;
        } catch (NumberFormatException ne) {
            throw formatException("UINT_16", argument, ne);
        }
    };

    BuiltInType<Long> UINT32 = Long::valueOf;

    BuiltInType<Long> UINT64 = Long::valueOf;

    /**
     * Section 9.4, RFC 6020
     * Human-readable string
     * <p>
     * string = *char
     * char = 0x9 / 0xA / 0xD / 0x20-0xD7FF / 0xE000-0xFFFD / 0x10000-0x10FFFF
     */
    BuiltInType<String> STRING = argument -> argument;

    /**
     * The leafref type is used to reference a particular leaf instance in the data tree.
     */
    BuiltInType<String> LEAFREF = argument -> argument;

    BuiltInType<String> UNION = argument -> argument;

    @AliasFor("instance-identifier")
    BuiltInType<String> INSTANCE_IDENTIFIER = argument -> argument;
}
