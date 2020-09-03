package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.Yang;
import com.jy.lang.builtin.BuiltInType;
import org.junit.Test;

public class TypeTest {
    @Test
    public void t1() {
        String schemas = "type string;";
        assert new Yang(schemas).getRoot(Type.class).getArgumentJava() == BuiltInType.STRING;
    }

    @Test(expected = SyntaxException.class)
    public void t12() {
        // unknown type string1
        String schemas = "type string1;";
        new Yang(schemas);
    }

    @Test
    public void t2() {
        String schemas = "" +
                "type string { \n" +
                "  pattern dad;\n" +
                "  length \"1|1..2\";\n" +
                "}";
        assert new Yang(schemas).getRoot().get(Length.class).getLengthList().get(0)[0] == 1;
    }

    @Test(expected = SyntaxException.class)
    public void t21() {
        String schemas = "" +
                // only string contains pattern and length
                "type int8 { \n" +
                "  pattern dad;\n" +
                "  length \"1|2\";\n" +
                "}";
        assert new Yang(schemas).getRoot().get(Length.class).getLengthList().get(0)[0] == 1;
    }

    @Test(expected = SyntaxException.class)
    public void t22() {
        FractionDigits digits = new FractionDigits();
        // digit num is too large
        digits.setArgument("19");
        digits.assertArgument();
    }

    @Test
    public void t23(){
        Type type = new Type();
        type.setArgument("decimal64");
        type.assertArgument();
        FractionDigits digits = new FractionDigits();
        digits.setArgument("18");
        digits.assertArgument();
        type.append(digits);
    }
}
