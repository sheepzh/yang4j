package com.bird.yang4j.core.lang;

import com.bird.yang4j.core.Context;
import com.bird.yang4j.core.util.StringUtils;
import com.bird.yang4j.core.SyntaxException;

import java.util.List;

/**
 * statement = keyword [argument] (";" /"{" *statement "}" )
 *
 * @author zhy
 */
public interface Statement {

    String getArgument();

    void setArgument(String argument);

    Statement getParent();

    void setParent(Statement parent);

    Context getContext();

    void setContext(Context context);

    /**
     * Assert that the child nodes is legal
     *
     * @throws SyntaxException if illegal
     */
    default void assertChild() throws SyntaxException {
        // do nothing
    }

    /**
     * Assert that the argument is legal
     *
     * @throws SyntaxException if illegal
     */
    default void assertArgument() throws SyntaxException {
        if (StringUtils.isBlank(getArgument())) {
            throw new SyntaxException("No argument!");
        }
    }

    /**
     * @param clz child statement class
     * @param <T> child statement type
     * @return child statement
     * @throws IllegalArgumentException while this statement must not contain this child
     */
    default <T extends Statement> T get(Class<T> clz) {
        throw new IllegalArgumentException("No such child statement");
    }

    /**
     * @param clz child statement class
     * @param <T> child statement type
     * @return children statement
     * @throws IllegalArgumentException while this statement must not contain this child
     */
    default <T extends Statement> List<T> getList(Class<T> clz) {
        throw new IllegalArgumentException("No such child statements");
    }
}
