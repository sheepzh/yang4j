package com.jy.lang.statement;

import com.jy.lang.BaseAppendableStatement;

/**
 * Section 7.17.2
 */
public class Argument extends BaseAppendableStatement {
    private YinElement yinElement;

    public YinElement getYinElement() {
        return yinElement;
    }

    public void setYinElement(YinElement yinElement) {
        this.yinElement = yinElement;
    }
}
