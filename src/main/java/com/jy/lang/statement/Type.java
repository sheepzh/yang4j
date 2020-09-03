package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.BaseAppendableStatement;
import com.jy.lang.Statement;
import com.jy.lang.builtin.BuiltInType;
import com.jy.lang.builtin.BuiltInTypeFactory;
import com.jy.lang.Valuable;
import com.jy.util.NameUtil;

import java.util.Arrays;
import java.util.List;

import static com.jy.lang.builtin.BuiltInType.*;

/**
 * Section 7.6.3
 */
public class Type extends BaseAppendableStatement implements Valuable<BuiltInType<?>> {

    // substatements

    // Used by STRING only
    private Length length;
    // Used by STRING only
    private List<Pattern> patternList;
    // Used by integer,unsigned integer or decimal only
    private Range range;
    // Used by decimal only
    private FractionDigits fractionDigits;

    private final static List<BuiltInType<?>> RANGE_OWNERS = Arrays.asList(
            INT8, INT16, INT32, INT64, UINT8, UINT16, UINT32, UINT64, DECIMAL64
    );

    @Override
    public BuiltInType<?> getArgumentJava() throws IllegalArgumentException {
        return assertValid0();
    }

    @Override
    public void assertArgument() throws SyntaxException {
        assertValid0();
    }

    @Override
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {
        BuiltInType<?> type = getArgumentJava();
        // Assert
        if (s instanceof Length || s instanceof Pattern) {
            if (!STRING.equals(type)) {
                // only 'type string' can contain length and pattern
                throw typeAndSubNotMatch(s);
            }
        } else if (s instanceof Range) {
            if (!RANGE_OWNERS.contains(type)) {
                throw typeAndSubNotMatch(s);
            }
        } else if (s instanceof FractionDigits) {
            if (!DECIMAL64.equals(type)) {
                throw typeAndSubNotMatch(s);
            }
        }
        super.append(s);
    }

    private SyntaxException typeAndSubNotMatch(Statement substatement) {
        return new SyntaxException("Built-in type '%s' mustn't contain substatement '%s'!", argument,
                NameUtil.java2Yang(substatement.getClass())
        );
    }

    private BuiltInType<?> assertValid0() {
        BuiltInType<?> builtInType = BuiltInTypeFactory.getInstance().product(argument);
        if (builtInType == null) {
            throw new SyntaxException("'%s' is unknown of built-in type ", argument);
        }
        return builtInType;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    public List<Pattern> getPatternList() {
        return patternList;
    }

    public void setPatternList(List<Pattern> patternList) {
        this.patternList = patternList;
    }
}
