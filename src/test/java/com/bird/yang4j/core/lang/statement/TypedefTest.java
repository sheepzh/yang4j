package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.Context;
import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.Yang;
import org.junit.Test;

import static com.bird.yang4j.core.lang.builtin.BuiltInType.INT8;

public class TypedefTest {

    @Test
    public void t1() {
        String schemas = "" +
                "typedef string-alias {" +
                "  type string;" +
                "}";
        new Yang(schemas);
    }

    @Test
    public void t2() {
        String schemas = "" +
                "module module{" +
                "  namespace \"a\";" +
                "  prefix dasda;" +
                "  typedef less-100 {" +
                "    type int8;" +
                "  }" +
                "  typedef weight {" +
                "    type less-100;" +
                "  }" +
                "  typedef net {" +
                // weight is defined before
                "    type weight;" +
                "  }" +
                "}";
        Context context = new Yang(schemas) // compile
                .getRoot(Module.class) // obtain the root statement
                .getContext(); // obtain the context
        assert context.getOriginTypeOf("net") == INT8;
        assert context.getOriginTypeOf("less-100") == INT8;
    }

    @Test(expected = SyntaxException.class)
    public void t21() {
        String schemas = "" +
                "module module{" +
                "  namespace \"a\";" +
                "  prefix dasda;" +
                "  typedef str {" +
                // str is defined after
                "    type str2;" +
                "  }" +
                "  typedef str2 {" +
                "    type string;" +
                "  }" +
                "}";
        new Yang(schemas);
    }
}
