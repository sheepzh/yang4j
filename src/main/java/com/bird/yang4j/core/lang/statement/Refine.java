package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

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
