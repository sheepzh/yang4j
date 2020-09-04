package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.BaseAppendableStatement;

/**
 * Section 7.1.6
 */
public class Include extends BaseAppendableStatement {
    private RevisionDate revisionDate;

    public RevisionDate getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(RevisionDate revisionDate) {
        this.revisionDate = revisionDate;
    }
}
