package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

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
