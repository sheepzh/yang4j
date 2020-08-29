package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.Yang;
import com.jy.parser.comment.DefaultCommentParser;
import org.junit.Test;

public class LeafTest {
    Yang yang = new Yang().setCommentParser(new DefaultCommentParser());

    /**
     * Default value does not match type
     */
    @Test(expected = SyntaxException.class)
    public void t1() {
        String schema = "leaf test-leaf{ type boolean; default 1;}";
        yang.setSchemas(schema).compile();
    }

    /**
     * Default value matches type
     */
    @Test
    public void t2() {
        String schema = "leaf test-leaf{ type boolean; default true;}";
        yang.setSchemas(schema).compile();
        schema = "leaf test-leaf{ type int8;default 2;}";
        yang.setSchemas(schema).compile();
    }

    /**
     * No required type substatement
     */
    @Test(expected = SyntaxException.class)
    public void t3() {
        String schema = "leaf test{}";
        yang.setSchemas(schema).compile();
    }
}
