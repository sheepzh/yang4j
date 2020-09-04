package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

import java.util.List;

/**
 * Section 7.13.3
 */
public class Output extends BaseAppendableStatement {
    private List<Anyxml> anyxmlList;
    private List<Choice> choiceList;
    private List<Container> containerList;
    private List<Grouping> groupingList;
    private List<Leaf> leafList;
    private List<LeafList> leafListList;
    private List<ListS> listList;
    private List<Typedef> typedefList;
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

    public List<Grouping> getGroupingList() {
        return groupingList;
    }

    public void setGroupingList(List<Grouping> groupingList) {
        this.groupingList = groupingList;
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

    public List<Typedef> getTypedefList() {
        return typedefList;
    }

    public void setTypedefList(List<Typedef> typedefList) {
        this.typedefList = typedefList;
    }

    public List<Uses> getUsesList() {
        return usesList;
    }

    public void setUsesList(List<Uses> usesList) {
        this.usesList = usesList;
    }
}
