package com.jy.parser.comment;

import com.jy.SyntaxException;

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of {@link CommentParser} with DFA, Deterministic Finite Automaton
 *
 * @author zhy
 */
public class DefaultCommentParser implements CommentParser {
    /**
     * States
     */
    private final static long INITIAL = 0;
    private final static long ONE_SLASH = 1;
    private final static long TWO_SLASHES = 2;
    private final static long SLASH_STAR = 3;
    private final static long SLASH_TWO_STARS = 4;
    private final static long SEGMENT_END = 5;

    private final static long STAR = '*';
    private final static long SLASH = '/';
    private final static long LINE = '\n';
    private final static long NONE = 0L;

    /**
     * Use matrix (x,y stored in one long value) to store the note state.
     * <p>
     * The lower 4 bits of the key means the input states;
     * The remain higher bits of the key means the input char;
     * <p>
     * The value means the output state
     * <p>
     * If none value is found, set input char = 0, to check again
     */
    private final static Map<Long, Long> STATE_MATRIX = new HashMap<>();
    private final static int SHIFT_BIT = 4;

    static {
        // [0, /] => 1
        trans(INITIAL, SLASH, ONE_SLASH);
        // [0,  ] => 0
        trans(INITIAL, NONE, INITIAL);
        // [1, /] => 2
        trans(ONE_SLASH, SLASH, TWO_SLASHES);
        // [1, *] => 3
        trans(ONE_SLASH, STAR, SLASH_STAR);
        // [1,  ] => 0
        trans(ONE_SLASH, NONE, INITIAL);
        // [2, \n] => 0
        trans(TWO_SLASHES, LINE, INITIAL);
        // [2,  ] => 2
        trans(TWO_SLASHES, NONE, TWO_SLASHES);
        // [3, *] => 4
        trans(SLASH_STAR, STAR, SLASH_TWO_STARS);
        // [3,  ] => 3
        trans(SLASH_STAR, NONE, SLASH_STAR);
        // [4, *] => 4
        trans(SLASH_TWO_STARS, STAR, SLASH_TWO_STARS);
        // [4, /] => 5
        trans(SLASH_TWO_STARS, SLASH, SEGMENT_END);
        // [4,  ] => 3
        trans(SLASH_TWO_STARS, NONE, SLASH_STAR);
        // [5, /] => 1
        trans(SEGMENT_END, SLASH, ONE_SLASH);
        // [5,  ] => 0
        trans(SEGMENT_END, NONE, INITIAL);
    }

    private static void trans(long inState, long ch, long outState) {
        STATE_MATRIX.put(merge(inState, ch), outState);
    }

    private static Long merge(long state, long c) {
        return state | c << SHIFT_BIT;
    }

    /**
     * Current state
     */
    private long current;

    public DefaultCommentParser() {
        current = INITIAL;
    }

    @Override
    public CommentParser accept(char c) {
        Long result = STATE_MATRIX.get(merge(current, c));
        current = result == null ? STATE_MATRIX.get(merge(current, NONE)) : result;
        return this;
    }

    @Override
    public boolean isOpen() {
        return current > INITIAL && current < SEGMENT_END;
    }

    @Override
    public void assertClose() throws SyntaxException {
        if (current != TWO_SLASHES) {
            // two slashes means closed also
            CommentParser.super.assertClose();
        }
    }

    @Override
    public void initialize() {
        current = 0;
    }
}
