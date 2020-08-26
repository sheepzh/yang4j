package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.10
 */
public class Anyxml extends BaseAppendableStatement {

    private Config config;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private Mandatory mandatory;
    private List<Must> mustList;
    private Reference reference;
    private Status status;
    private When when;

    public Config getConfig() {
        return config;
    }

    public Anyxml setConfig(Config config) {
        this.config = config;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Anyxml setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Anyxml setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public Mandatory getMandatory() {
        return mandatory;
    }

    public Anyxml setMandatory(Mandatory mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public List<Must> getMustList() {
        return mustList;
    }

    public Anyxml setMustList(List<Must> mustList) {
        this.mustList = mustList;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Anyxml setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Anyxml setStatus(Status status) {
        this.status = status;
        return this;
    }

    public When getWhen() {
        return when;
    }

    public Anyxml setWhen(When when) {
        this.when = when;
        return this;
    }
}
