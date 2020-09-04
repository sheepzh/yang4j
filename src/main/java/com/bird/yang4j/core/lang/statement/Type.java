package com.bird.yang4j.core.lang.statement;

import com.bird.yang4j.core.lang.builtin.BuiltInTypeFactory;
import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.BaseAppendableStatement;
import com.bird.yang4j.core.lang.Statement;
import com.bird.yang4j.core.lang.builtin.BuiltInType;
import com.bird.yang4j.core.lang.Valuable;
import com.bird.yang4j.core.util.NameUtil;

import java.util.Arrays;
import java.util.List;

import static com.bird.yang4j.core.lang.builtin.BuiltInType.*;

/**
 * Section 7.6.3
 */
public class Type extends BaseAppendableStatement implements Valuable<BuiltInType<?>> {

    // substatements
    /**
     * Used by {@link BuiltInType#ENUMERATION} only
     */
    private List<EnumS> enumList;
    /**
     * Used by {@link BuiltInType#BITS} only
     */
    private List<Bit> bitList;
    /**
     * Used by {@link BuiltInType#STRING} or {@link BuiltInType#BINARY} only
     */
    private Length length;
    /**
     * Used by {@link BuiltInType#STRING} only
     */
    private List<Pattern> patternList;
    /**
     * Used by integer,unsigned integer or decimal only, see {@link #RANGE_OWNERS}
     */
    private Range range;
    /**
     * Used by {@link BuiltInType#DECIMAL64} only
     */
    private FractionDigits fractionDigits;
    /**
     * Used by {@link BuiltInType#LEAFREF} only
     */
    private Path path;
    /**
     * Used by {@link BuiltInType#IDENTITYREF} only
     */
    private Base base;
    /**
     * Used by {@link BuiltInType#UNION} only
     */
    private List<Type> typeList;
    /**
     * Used by {@link BuiltInType#INSTANCE_IDENTIFIER}
     */
    private RequireInstance requireInstance;

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
    public void assertChild() throws SyntaxException {
        super.assertChild();
        if (enumList != null && !enumList.isEmpty()) {
            // assert the enums value
            assertEnum();
        } else if (bitList != null && !bitList.isEmpty()) {
            // assert the bits' name
            assertBits();
        } else if (getArgumentJava().equals(UNION)) {
            if (typeList == null || typeList.isEmpty()) {
                throw new SyntaxException("When the type is 'union', the 'type' statement MUST be present.");
            }
            boolean invalidSub = typeList.stream()
                    .map(Type::getArgumentJava)
                    .distinct()
                    .anyMatch(bit -> EMPTY == bit || LEAFREF == bit);
            if (invalidSub) {
                throw new SyntaxException("A member type of 'union' type MUST NOT be one of the built-in " +
                        "types 'empty' or 'leafref'!");
            }
        }
    }

    private void assertEnum() {
        Integer previous = null;
        for (EnumS e : enumList) {
            Value value = e.getValue();
            if (previous == null) {
                previous = value == null ? 0 : value.getArgumentJava();
            } else if (previous == Value.MAX) {
                throw new SyntaxException("The enum '%s' must not happen after the enum with max value!",
                        e.getArgument(), Value.MAX);
            } else {
                if (value != null) {
                    int newVal = value.getArgumentJava();
                    if (newVal <= previous) {
                        throw new SyntaxException("The value of enums must be ascending in '%s'!", argument);
                    } else previous = newVal;
                } else {
                    previous++;
                }
            }
        }
    }

    private void assertBits() {
        long nameNum = bitList.stream().map(Statement::getArgument).distinct().count();
        if (nameNum != bitList.size()) {
            throw new SyntaxException("All assigned names in the bits type '%s' MUST be unique!", argument);
        }

        Long previous = null;
        for (Bit bit : bitList) {
            Position position = bit.getPosition();
            if (previous == null) {
                previous = position == null ? 0 : position.getArgumentJava();
            } else if (previous == Position.MAX) {
                throw new SyntaxException("Bit '%s' must not happen after the bit with max position '%d'!",
                        bit.getArgument(), Position.MAX);
            } else {
                if (position != null) {
                    long newVal = position.getArgumentJava();
                    if (newVal <= previous) {
                        throw new SyntaxException("The position of bits must be ascending in '%s'!", argument);
                    } else previous = newVal;
                } else {
                    previous++;
                }
            }
        }
    }

    @Override
    public <T extends Statement> void append(T s) throws SyntaxException, NullPointerException {
        BuiltInType<?> type = getArgumentJava();
        // Assert
        if (s instanceof Length) {
            if (!STRING.equals(type) && !BINARY.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof Pattern) {
            if (!STRING.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof Range) {
            if (!RANGE_OWNERS.contains(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof FractionDigits) {
            if (!DECIMAL64.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof EnumS) {
            if (!ENUMERATION.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof Bit) {
            if (!BITS.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof Path) {
            if (!LEAFREF.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof Base) {
            if (!IDENTITYREF.equals(type)) throw typeAndSubNotMatch(s);
        } else if (s instanceof Type) {
            if (!UNION.equals(getArgumentJava())) throw typeAndSubNotMatch(s);
        } else if (s instanceof RequireInstance) {
            if (!INSTANCE_IDENTIFIER.equals(getArgumentJava())) throw typeAndSubNotMatch(s);
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
            builtInType = context.getOriginTypeOf(argument);
        }
        if (builtInType == null) {
            throw new SyntaxException("'%s' is one unknown built-in type ", argument);
        }
        return builtInType;
    }

    public List<EnumS> getEnumList() {
        return enumList;
    }

    public void setEnumList(List<EnumS> enumList) {
        this.enumList = enumList;
    }

    public List<Bit> getBitList() {
        return bitList;
    }

    public void setBitList(List<Bit> bitList) {
        this.bitList = bitList;
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

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public FractionDigits getFractionDigits() {
        return fractionDigits;
    }

    public void setFractionDigits(FractionDigits fractionDigits) {
        this.fractionDigits = fractionDigits;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public RequireInstance getRequireInstance() {
        return requireInstance;
    }

    public void setRequireInstance(RequireInstance requireInstance) {
        this.requireInstance = requireInstance;
    }
}
