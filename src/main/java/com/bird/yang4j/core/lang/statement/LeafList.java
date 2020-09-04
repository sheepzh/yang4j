package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.7
 */
public class LeafList extends BaseAppendableStatement {
    /**
     * Must not be null
     */
    private Type type;

    private Config config;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private MaxElements maxElements;
    private MinElements minElements;
    private List<Must> mustList;
    private OrderedBy orderedBy;
    private Reference reference;
    private Status status;
    private Units units;
    private When when;

    @Override
    public void assertChild() throws SyntaxException {
        super.assertChild();
        required(type, Type.class);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
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

    public MaxElements getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(MaxElements maxElements) {
        this.maxElements = maxElements;
    }

    public MinElements getMinElements() {
        return minElements;
    }

    public void setMinElements(MinElements minElements) {
        this.minElements = minElements;
    }

    public List<Must> getMustList() {
        return mustList;
    }

    public void setMustList(List<Must> mustList) {
        this.mustList = mustList;
    }

    public OrderedBy getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(OrderedBy orderedBy) {
        this.orderedBy = orderedBy;
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

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public When getWhen() {
        return when;
    }

    public void setWhen(When when) {
        this.when = when;
    }
}
