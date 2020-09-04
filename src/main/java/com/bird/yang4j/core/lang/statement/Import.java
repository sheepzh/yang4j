package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.BaseAppendableStatement;

/**
 * Section 7.1.5
 */
public class Import extends BaseAppendableStatement {
    /**
     * Must not be null
     */
    private Prefix prefix;

    private RevisionDate revisionDate;

    @Override
    public void assertChild() throws SyntaxException {
        super.assertChild();
        required(prefix, Prefix.class);
    }
}
