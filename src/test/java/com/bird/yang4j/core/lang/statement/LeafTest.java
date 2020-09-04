package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.Yang;
import com.bird.yang4j.core.SyntaxException;
import org.junit.Test;

public class LeafTest {

    /**
     * Default value does not match type
     */
    @Test(expected = SyntaxException.class)
    public void t1() {
        String schema = "leaf test-leaf{ type boolean; default 1;}";
        new Yang(schema);
    }

    /**
     * Default value matches type
     */
    @Test
    public void t2() {
        String schema = "leaf test-leaf{ type boolean; default true;}";
        new Yang(schema);
        schema = "leaf test-leaf{ type int8;default 2;}";
        new Yang(schema);
    }

    /**
     * No required type substatement
     */
    @Test(expected = SyntaxException.class)
    public void t3() {
        String schema = "leaf test{}";
        new Yang(schema);
    }
}
