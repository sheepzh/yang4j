package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

/**
 * Section 7.5.3
 */
public class Must extends BaseAppendableStatement {
    private Description description;
    private ErrorAppTag errorAppTag;
    private ErrorMessage errorMessage;
    private Reference reference;

    public Description getDescription() {
        return description;
    }

    public Must setDescription(Description description) {
        this.description = description;
        return this;
    }

    public ErrorAppTag getErrorAppTag() {
        return errorAppTag;
    }

    public Must setErrorAppTag(ErrorAppTag errorAppTag) {
        this.errorAppTag = errorAppTag;
        return this;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public Must setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Must setReference(Reference reference) {
        this.reference = reference;
        return this;
    }
}
