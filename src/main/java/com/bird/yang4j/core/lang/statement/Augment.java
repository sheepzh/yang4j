package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.15
 */
public class Augment extends BaseAppendableStatement {
    private List<Anyxml> anyxmlList;
    private List<Case> caseList;
    private List<Choice> choiceList;
    private Description description;
    private List<IfFeature> ifFeatureList;
    private List<Leaf> leaf;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private Reference reference;
    private Status status;
    private List<Uses> uses;
    private When when;

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public void setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
    }

    public List<Case> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<Case> caseList) {
        this.caseList = caseList;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
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

    public List<Leaf> getLeaf() {
        return leaf;
    }

    public void setLeaf(List<Leaf> leaf) {
        this.leaf = leaf;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public void setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
    }

    public List<ListS> getListList() {
        return listList;
    }

    public void setListList(List<ListS> listList) {
        this.listList = listList;
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

    public List<Uses> getUses() {
        return uses;
    }

    public void setUses(List<Uses> uses) {
        this.uses = uses;
    }

    public When getWhen() {
        return when;
    }

    public void setWhen(When when) {
        this.when = when;
    }
}
