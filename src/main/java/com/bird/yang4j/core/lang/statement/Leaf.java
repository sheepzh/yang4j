package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;
import com.bird.yang4j.core.lang.annotation.AliasFor;

import java.util.List;

/**
 * Section 7.6
 */
public class Leaf extends BaseAppendableStatement {
    /**
     * Must not be null
     */
    private Type type;

    private Config config;
    @AliasFor("default")
    private Default defaultS;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private Mandatory mandatory;
    private List<Must> mustList;
    private Reference reference;
    private Status status;
    private Units units;
    private When when;

    @Override
    public void assertChild() {
        super.assertChild();
        required(type, Type.class);
        assertDefault(type, defaultS);
    }

    public Type getType() {
        return type;
    }

    public Leaf setType(Type type) {
        this.type = type;
        return this;
    }

    public Config getConfig() {
        return config;
    }

    public Leaf setConfig(Config config) {
        this.config = config;
        return this;
    }

    public Default getDefaultS() {
        return defaultS;
    }

    public Leaf setDefaultS(Default defaultS) {
        this.defaultS = defaultS;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Leaf setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public Leaf setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
        return this;
    }

    public Mandatory getMandatory() {
        return mandatory;
    }

    public Leaf setMandatory(Mandatory mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public List<Must> getMustList() {
        return mustList;
    }

    public Leaf setMustList(List<Must> mustList) {
        this.mustList = mustList;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Leaf setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Leaf setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Units getUnits() {
        return units;
    }

    public Leaf setUnits(Units units) {
        this.units = units;
        return this;
    }

    public When getWhen() {
        return when;
    }

    public Leaf setWhen(When when) {
        this.when = when;
        return this;
    }
}
