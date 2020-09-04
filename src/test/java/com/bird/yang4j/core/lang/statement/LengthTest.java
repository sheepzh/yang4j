package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.Yang;
import com.bird.yang4j.core.SyntaxException;
import org.junit.Test;

import java.util.List;

public class LengthTest {

    private final Length length = new Length();

    @Test
    public void t1() {
        length.setArgument("001");
        length.assertArgument();
    }

    @Test
    public void t11() {
        length.setArgument("+001");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t12() {
        // negative, decimal
        length.setArgument("-0.1");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t13() {
        // decimal
        length.setArgument("0.2");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t14() {
        // not number
        length.setArgument("f_o");
        length.assertArgument();
    }

    @Test
    public void t2() {
        length.setArgument("1..255");
        length.assertArgument();
        List<long[]> segments = length.getLengthList();
        assert segments.get(0)[0] == 1;
        assert segments.get(0)[1] == 255;
    }

    @Test(expected = SyntaxException.class)
    public void t21() {
        // too many dots
        length.setArgument("1...255");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t3() {
        length.setArgument("max..1");
        // error because max is greater than 1
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t4() {
        // not in ascending order
        length.setArgument("max|min..1");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t41() {
        // not disjoint
        length.setArgument("max|max");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t42() {
        // not disjoint
        length.setArgument("0..20|18..22");
        length.assertArgument();
    }

    @Test
    public void t43() {
        length.setArgument("1|2..4|max");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t5() {
        String schemas = "" +
                "length \"6| 7.. 32| max\"{\n" +
                "  description \"length test\";\n" +
                // 'length' must not contain 'type'.
                "  type binary;" +
                "}";
        new Yang(schemas);
    }
}
