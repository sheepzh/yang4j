package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.18.1
 */
public class Feature extends BaseAppendableStatement {
    private Description description;
    private List<IfFeature> ifFeatureList;
    private Status status;
    private Reference reference;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public void setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
