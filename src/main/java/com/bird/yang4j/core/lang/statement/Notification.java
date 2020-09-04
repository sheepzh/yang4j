package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.14
 */
public class Notification extends BaseAppendableStatement {
    private List<Anyxml> anyxmlList;
    private List<Choice> choiceList;
    private List<Container> containerList;
    private Description description;
    private List<Grouping> groupingList;
    private List<IfFeature> ifFeatureList;
    private List<Leaf> leafList;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private Reference reference;
    private Status status;
    private List<Typedef> typedef;
    private List<Uses> usesList;

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public void setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public void setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
    }

    public List<IfFeature> getIfFeatureList() {
        return ifFeatureList;
    }

    public void setIfFeatureList(List<IfFeature> ifFeatureList) {
        this.ifFeatureList = ifFeatureList;
    }

    public List<Leaf> getLeafList() {
        return leafList;
    }

    public void setLeafList(List<Leaf> leafList) {
        this.leafList = leafList;
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

    public List<Typedef> getTypedef() {
        return typedef;
    }

    public void setTypedef(List<Typedef> typedef) {
        this.typedef = typedef;
    }

    public List<Uses> getUsesList() {
        return usesList;
    }

    public void setUsesList(List<Uses> usesList) {
        this.usesList = usesList;
    }
}
