package com.jy.parser;

import com.jy.lang.Statement;
import com.sun.tools.classfile.ConstantPool;

/**
 * Parser of YANG schema
 *
 * @author zhy
 */
public class Yang {
    private final static String MODULE_TOKEN = "module";

    private StringBuffer buf = new StringBuffer();

    private Statement root;

    /**
     * The statement has been read before now.
     */
    private final boolean statementFlag = false;

    public Yang(String schema) {
        for (char c : schema.toCharArray()) {
            if (isModule()) {

            }
        }
    }

    /**
     * Determines statement
     *
     * @return true if one statement is scanned just, or false
     */
    private boolean isStatement() {
        if (statementFlag) return false;
        return false;
    }

    /**
     * Determines to be module
     */
    private boolean isModule() {
        return buf.toString().endsWith(MODULE_TOKEN);
    }

    private boolean readStatement() {
        return false;
    }
}
