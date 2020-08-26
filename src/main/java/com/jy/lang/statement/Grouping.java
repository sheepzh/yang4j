package com.jy.lang.statement;

import com.jy.lang.AbstractStatement;

import java.util.List;

/**
 * Section 7.11
 */
public class Grouping extends AbstractStatement {
    private List<Anyxml> anyxmlList;
    private List<Choice> choiceList;
    private List<Container> containerList;
    private Description description;
    private List<Grouping> groupingList;
    private List<Leaf> leaves;
    private List<LeafList> leafListList;
    private Reference reference;
    private Status status;
    private List<Typedef> typedefList;
    private List<Uses> usesList;

    public List<Anyxml> getAnyxmlList() {
        return anyxmlList;
    }

    public Grouping setAnyxmlList(List<Anyxml> anyxmlList) {
        this.anyxmlList = anyxmlList;
        return this;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public Grouping setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
        return this;
    }

    public List<Container> getContainerList() {
        return containerList;
    }

    public Grouping setContainerList(List<Container> containerList) {
        this.containerList = containerList;
        return this;
    }

    public Description getDescription() {
        return description;
    }

    public Grouping setDescription(Description description) {
        this.description = description;
        return this;
    }

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public Grouping setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
        return this;
    }

    public List<Leaf> getLeaves() {
        return leaves;
    }

    public Grouping setLeaves(List<Leaf> leaves) {
        this.leaves = leaves;
        return this;
    }

    public List<LeafList> getLeafListList() {
        return leafListList;
    }

    public Grouping setLeafListList(List<LeafList> leafListList) {
        this.leafListList = leafListList;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Grouping setReference(Reference reference) {
        this.reference = reference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Grouping setStatus(Status status) {
        this.status = status;
        return this;
    }

    public List<Typedef> getTypedefList() {
        return typedefList;
    }

    public Grouping setTypedefList(List<Typedef> typedefList) {
        this.typedefList = typedefList;
        return this;
    }

    public List<Uses> getUsesList() {
        return usesList;
    }

    public Grouping setUsesList(List<Uses> usesList) {
        this.usesList = usesList;
        return this;
    }
}
