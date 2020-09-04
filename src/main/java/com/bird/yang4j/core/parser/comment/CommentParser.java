package com.bird.yang4j.core.parser.comment;

import com.bird.yang4j.core.SyntaxException;

/**
 * YANG comment parser
 * <p>
 * For usage example:
 * boolean doNext = !parser.accept('/').isOpen()
 *
 * @author zhy
 */
public interface CommentParser {
    /**
     * Will accept one char as input
     *
     * @param c input char
     * @return this
     */
    CommentParser accept(char c);

    /**
     * Judge if the state of comment is OPEN
     * The char is open means that it won't be influential next, since as one token of current comment.
     *
     * @return true if open, or false
     */
    boolean isOpen();

    /**
     * Assert the parser is not open, or throws {@link SyntaxException }
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
