package com.jy;

import org.junit.Test;

public class YangTest {

    @Test
    public void rpc() {
        String schema = "" +
                "// Contents of \"acme-system.yang\"\n" +
                "module acme-system {\n" +
                "/**\n" +
                "  This note is for test\n" +
                "**/\n" +
                "  namespace \"http://acme.example.com/system\";\n" +
                "  prefix \"acme\";\n" +
                "  organization \"ACME Inc.\";\n" +
                "  contact \"joe@acme.example.com\";\n" +
                "  description\n" +
                "    \"The module for entities implementing the ACME system.\";\n" +
                "  revision 2007-06-09 {\n" +
                "    description \"Initial revision.\";\n" +
                "  }\n" +
                "  container system {\n" +
                "    leaf host-name {\n" +
                "      type string;\n" +
                "      description \"Hostname for this system\";\n" +
                "    }\n" +
                "    leaf-list domain-search {\n" +
                "      type string;\n" +
                "      description \"List of domain names to search\";\n" +
                "    }\n" +
                "    container login {\n" +
                "      leaf message {\n" +
                "        type string;\n" +
                "        description\n" +
                "          \"Message given at start of login session\";\n" +
                "      }\n" +
                "      list user {\n" +
                "        key \"name\";\n" +
                "        leaf name {\n" +
                "          type string;\n" +
                "        }\n" +
                "        leaf full-name {\n" +
                "          type string;\n" +
                "        }\n" +
                "        leaf class {\n" +
                "          type string;\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        new Yang(schema);
    }

    @Test(expected = SyntaxException.class)
    public void anyxml() {
        String schema = "" +
                // "foo" is error token
                "anyxml activate-software-image foo{\n" +
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
        new Yang(schema);
    }
}
