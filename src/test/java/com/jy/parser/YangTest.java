package com.jy.parser;

import com.jy.lang.statement.Rpc;
import org.junit.Assert;
import org.junit.Test;

public class YangTest {
    @Test
    public void rpc() {
        String schema = "" +
                "rpc activate-software-image {\n" +
                "  input {\n" +
                "    leaf image-name {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "  output {\n" +
                "    leaf status {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Assert.assertTrue(new Yang(schema).getRoot() instanceof Rpc);
    }

    @Test
    public void anyxml() {
        String schema = "" +
                "anyxml activate-software-image {\n" +
                "  input {\n" +
                "    leaf image-name {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "  output {\n" +
                "    leaf status {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Yang yang = new Yang(schema);
    }
}
