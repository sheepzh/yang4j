package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.12
 */
public class Uses extends BaseAppendableStatement {
    private Augment augment;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private Refine refine;
    private Reference reference;
    private Status status;
    private When when;

    public Augment getAugment() {
        return augment;
    }

    public void setAugment(Augment augment) {
        this.augment = augment;
    }

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

    public Refine getRefine() {
        return refine;
    }

    public void setRefine(Refine refine) {
        this.refine = refine;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public When getWhen() {
        return when;
    }

    public void setWhen(When when) {
        this.when = when;
    }
}
