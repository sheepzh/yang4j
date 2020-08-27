package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.parser.Yang;
import com.jy.parser.note.DefaultNoteParser;
import org.junit.Test;

public class LeafTest {
    Yang yang = new Yang().setNoteParser(new DefaultNoteParser());

    /**
     * Default value does not match type
     */
    @Test(expected = SyntaxException.class)
    public void t1() {
        String schema = "leaf test-leaf{ type boolean; default 1;}";
        yang.setSchema(schema).build().assertValid();
    }

    /**
     * Default value matches type
     */
    @Test
    public void t2() {
        String schema = "leaf test-leaf{ type boolean; default true;}";
        yang.setSchema(schema).build().assertValid();
        schema = "leaf test-leaf{ type int8;default 2;}";
        yang.setSchema(schema).build().assertValid();
    }

    /**
     * No required type substatement
     */
    @Test(expected = SyntaxException.class)
    public void t3() {
        String schema = "leaf test{}";
        yang.setSchema(schema).build().assertValid();
    }
}
