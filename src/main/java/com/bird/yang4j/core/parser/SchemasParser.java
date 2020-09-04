package com.bird.yang4j.core.parser;

import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.Statement;
import com.bird.yang4j.core.parser.comment.CommentParser;

/**
 * Parser of schemas
 *
 * @author zhy
 */
public interface SchemasParser {
    /**
     * Parse the schemas
     *
     * @param schemas schemas of YANG
     * @return root statement
     * @throws NullPointerException if the schemas is blank
     * @throws SyntaxException      if syntax error happens in the schemas
     */
    Statement parse(String schemas);

    /**
     * Set the comment parser
     *
     * @param commentParser parser for comment in YANG
     * @return this
     */
    SchemasParser setCommentParser(CommentParser commentParser);
}
