package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;
import com.bird.yang4j.core.SyntaxException;

import java.util.LinkedList;
import java.util.List;

/**
 * Section 9.4.4
 */
public class Length extends BaseAppendableStatement {
    public static int LENGTH_MAX = Integer.MAX_VALUE;
    public static int LENGTH_MIN = Integer.MIN_VALUE;
    private static final String LENGTH_MAX_STR = "max";
    private static final String LENGTH_MIN_STR = "min";

    // substatements
    private Description description;
    private ErrorAppTag errorAppTag;
    private ErrorMessage errorMessage;
    private Reference reference;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public ErrorAppTag getErrorAppTag() {
        return errorAppTag;
    }

    public void setErrorAppTag(ErrorAppTag errorAppTag) {
        this.errorAppTag = errorAppTag;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    @Override
    public void assertArgument() throws SyntaxException {
        super.assertArgument();
        lengthList.clear();
        String[] strings = argument.split("\\|");
        // Section 9.4.4, RFC 6020
        // If multiple values or ranges are given, they all MUST be disjoint and MUST be in ascending order.
        long previousMax = -1;
        for (String str : strings) {
            String[] nums = str.split("\\.\\.");
            if (nums.length == 1) {
                long val = parseToLong(str);
                previousMax = assertAscending(previousMax, val);
                lengthList.add(new long[]{parseToLong(str)});
            } else if (nums.length == 2) {
                long left = parseToLong(nums[0]);
                long right = parseToLong(nums[1]);
                previousMax = assertAscending(previousMax, left);
                previousMax = assertAscending(previousMax, right);
                if (left == right) {
                    lengthList.add(new long[]{left});
                } else if (left < right) {
                    lengthList.add(new long[]{left, right});
                } else {
                    throw new SyntaxException("'%s' can't be left '%s'", left, right);
                }
            }
        }
    }

    private long parseToLong(String str) {
        str = str.trim();
        if (LENGTH_MAX_STR.equals(str)) return LENGTH_MAX;
        else if (LENGTH_MIN_STR.equals(str)) return LENGTH_MIN;
        else {
            try {
                long result = Long.parseLong(str);
                if (result < 0) throw new SyntaxException("'%s' is negative");
                return result;
            } catch (NumberFormatException e) {
                throw new SyntaxException("'%s'", str);
            }
        }
    }

    private long assertAscending(long previous, long newVal) {
        if (newVal <= previous) {
            throw new SyntaxException("It's not in ascending order that '%s' is before '%s'.",
                    longToMaxOrMin(previous), longToMaxOrMin(newVal)
            );
        }
        return newVal;
    }

    private String longToMaxOrMin(long val) {
        if (val == LENGTH_MAX) return LENGTH_MAX_STR;
        if (val == LENGTH_MIN) return LENGTH_MIN_STR;
        return String.valueOf(val);
    }

    private final List<long[]> lengthList = new LinkedList<>();

    public List<long[]> getLengthList() {
        return lengthList;
    }
}
