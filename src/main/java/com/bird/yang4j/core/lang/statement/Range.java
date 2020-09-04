package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

/**
 * Section 9.2.5
 */
public class Range extends BaseAppendableStatement {
    public static int LENGTH_MAX = Integer.MAX_VALUE;
    public static int LENGTH_MIN = Integer.MIN_VALUE;
    private static final String LENGTH_MAX_STR = "max";
    private static final String LENGTH_MIN_STR = "min";

    // substatements
    private Description description;
    private ErrorAppTag errorAppTag;
    private ErrorMessage errorMessage;
    private Reference reference;
}
