package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

import java.util.List;

/**
 * Section 7.1
 */
public class Module extends AbstractStatement {

    /**
     * Mustn't be null
     */
    private Namespace namespace;
    /**
     * Must't be null
     */
    private Prefix prefix;

    private List<Anyxml> anyxmlList;
    private List<Augment> augments;
    private List<Choice> choiceList;
    private Contact contact;
    private List<Container> containerList;
    private Description description;
    private List<Deviation> deviationList;
    private List<Extension> extensionList;
    private List<Feature> featureList;
    private List<Grouping> groupingList;
    private List<Identity> identityList;
    private List<Import> importList;
    private List<Include> includeList;
    private List<Leaf> leaves;
    private List<LeafList> leafListList;
    private List<com.jy.lang.statement.List> listList;
    private List<Notification> notificationList;
    private Organization organization;
    private Reference reference;
    private List<Revision> revisionList;
    private List<Rpc> rpc;
    private List<Typedef> typedefList;
    private List<Uses> usesList;

    @Override
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {
        super.append(s);
    }
}
