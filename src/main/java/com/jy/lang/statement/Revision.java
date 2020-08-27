package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

/**
 * Section 7.1.9
 */
public class Revision extends BaseAppendableStatement {
    private Description description;
    private Reference reference;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
