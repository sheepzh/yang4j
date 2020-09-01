package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.Yang;
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
        length.setArgument("-0.1");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t13() {
        length.setArgument("0.2");
        length.assertArgument();
    }

    @Test(expected = SyntaxException.class)
    public void t14() {
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
        length.setArgument("max|min|max..1");
        // error because max is greater than 1
        length.assertArgument();
    }

    @Test
    public void t4() {
        length.setArgument("max|min|min..1");
        length.assertArgument();
        List<long[]> segments = length.getLengthList();
        assert segments.size() == 3;
        assert segments.get(0).length == 1;
        assert segments.get(1)[0] == Length.LENGTH_MIN;
    }

    @Test
    public void t5() {
        String schemas = "" +
                "length \"6| 7.. 32| max\"{\n" +
                "  description \"length test\";\n" +
                "  type binary;" +
                "}";
        new Yang(schemas);
    }
}
