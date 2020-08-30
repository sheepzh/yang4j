package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

/**
 * 7.12.2
 */
public class Refine extends BaseAppendableStatement {
    private Description description;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
