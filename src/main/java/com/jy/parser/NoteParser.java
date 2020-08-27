package com.jy.parser;

import com.jy.SyntaxException;

/**
 * YANG note parser
 * <p>
 * For example:
 * boolean doNext = parser.accept('/').isClose()
 *
 * @author zhy
 */
public interface NoteParser {
    /**
     * Will accept one char as input
     *
     * @param c input char
     * @return this
     */
    NoteParser accept(char c);

    /**
     * Judge if the state of note is OPEN
     * The char is open means that it won't be influential next, since as one token of current note.
     *
     * @return true if open, or false
     */
    boolean isOpen();

    /**
     * Assert the parser is not open, or throws {@link com.jy.SyntaxException }
     */
    default void assertClose() throws SyntaxException {
        if (isOpen()) {
            throw new SyntaxException("Note syntax error");
        }
    }

    /**
     * Initialize this parser
     */
    void initialize();
}
