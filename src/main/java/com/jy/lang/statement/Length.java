package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.BaseAppendableStatement;

import java.util.LinkedList;
import java.util.List;

/**
 * Section 9.4.4
 */
public class Length extends BaseAppendableStatement {
    public static int LENGTH_MAX = Integer.MAX_VALUE;
    public static int LENGTH_MIN = Integer.MIN_VALUE;

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
        for (String str : strings) {
            String[] nums = str.split("\\.\\.");
            if (nums.length == 1) {
                lengthList.add(new long[]{parseToLong(str)});
            } else if (nums.length == 2) {
                long left = parseToLong(nums[0]);
                long right = parseToLong(nums[1]);
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
        if (str.equals("max")) return LENGTH_MAX;
        else if (str.equals("min")) return LENGTH_MIN;
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

    private final List<long[]> lengthList = new LinkedList<>();

    public List<long[]> getLengthList() {
        return lengthList;
    }
}
