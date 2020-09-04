package com.bird.yang4j.core.parser;

import com.bird.yang4j.core.Context;
import com.bird.yang4j.core.lang.ChildrenAppendable;
import com.bird.yang4j.core.lang.StatementFactory;
import com.bird.yang4j.core.util.CharUtils;
import com.bird.yang4j.core.util.NameUtil;
import com.bird.yang4j.core.util.StringUtils;
import com.bird.yang4j.core.SyntaxException;
import com.bird.yang4j.core.lang.Statement;
import com.bird.yang4j.core.parser.comment.CommentParser;
import com.bird.yang4j.core.parser.comment.DefaultCommentParser;

/**
 * Simple schemas parser
 */
public class DefaultSchemasParser implements SchemasParser {

    private final StringBuilder tokens = new StringBuilder();

    private final StatementFactory statementFactory = StatementFactory.getInstance();

    private Statement result = null;

    private Statement buf = null;

    private int currentLine = 1;

    private CommentParser commentParser;

    @Override
    public Statement parse(String schemas) {
        init();

        int quoted = 0;
        boolean previousCommentOpen = false;
        boolean needQuoted = false;
        int leftBraceNum = 0;
        for (char c : schemas.toCharArray()) {
            if (c == '\n') currentLine++;
            // single
            if ((quoted & 1) == 1) {
                if (c == '"') {
                    quoted++;
                } else {
                    // Regard blank character between quotes as one token
                    tokens.append(c);
                }
                continue;
            }
            // note
            if (commentParser.accept(c).isOpen()) {
                previousCommentOpen = true;
                continue;
            } else if (previousCommentOpen) {
                // previous is open, then comment is end currently
                previousCommentOpen = false;
                continue;
            }
            previousCommentOpen = false;
            if (CharUtils.isNotBlank(c)) {
                if (needQuoted && c != '"') {
                    throw new SyntaxException("Need '\"' after '+' in line %d!", currentLine);
                }
                if (c == '{') {
                    reduce();
                    if (buf == null) {
                        throw new SyntaxException("Need keyword [ argument ] before '{' in line %d!", currentLine);
                    }
                    assertArgument();
                    push();
                    leftBraceNum++;
                } else if (c == ';') {
                    reduce();
                    assertArgument();
                    if (buf == null || StringUtils.isBlank(buf.getArgument())) {
                        throw new SyntaxException("Need keyword and argument before ';' in line %d!", currentLine);
                    }
                    // Merge the substatements;
                    merge();
                } else if (c == '}') {
                    if (leftBraceNum == 0) {
                        throw new SyntaxException("Duplicate right brace in line %d!", currentLine);
                    }
                    if (buf != null) {
                        throw new SyntaxException("Need ';' before '}' in line %d!", currentLine);
                    }
                    // Current statement is over, then pop it and add it into the parent's child list
                    buf = pop();
                    merge();
                    leftBraceNum--;
                } else if (c == '"') {
                    quoted++;
                    needQuoted = false;
                } else if (c == '+') {
                    if (quoted > 0 && (quoted & 1) == 0) {
                        needQuoted = true;
                    }
                } else {
                    if (buf != null && buf.getArgument() != null) {
                        throw new SyntaxException("Any tokens are not expected after the argument '%s' in line %d",
                                buf.getArgument(), currentLine);
                    }
                    tokens.append(c);
                }
            } else {
                reduce();
            }
        }
        commentParser.assertClose();
        if ((quoted & 1) == 1) {
            throw new SyntaxException("Double quoted is not close at the end!");
        }
        result.assertChild();

        return result;
    }

    @Override
    public SchemasParser setCommentParser(CommentParser commentParser) {
        if (commentParser == null) commentParser = new DefaultCommentParser();
        this.commentParser = commentParser;
        return this;
    }


    /**
     * Reduce tokens to the argument or the keyword
     */
    private void reduce() {
        if (tokens.length() > 0) {
            String word = tokens.toString();
            if (buf == null) {
                // need generate one
                try {
                    // generate inheritance context
                    Context context = new Context();
                    buf = pop();
                    if (buf != null) {
                        context.setParent(buf.getContext());
                        push();
                    }
                    // product new statement
                    buf = statementFactory.product(word);
                    buf.setContext(context);
                } catch (IllegalArgumentException e) {
                    throw new SyntaxException(e,
                            "'%s' is not one valid keyword of statement in line %d", word, currentLine);
                }
            } else {
                buf.setArgument(word);
            }
            // Clean the tokens
            tokens.delete(0, tokens.length());
        }
    }

    /**
     * Assert argument
     */
    private void assertArgument() {
        try {
            buf.assertArgument();
        } catch (SyntaxException se) {
            throw new SyntaxException("Argument error in line %s: " + se.getMessage(), currentLine);
        }
    }

    private void push() {
        buf.setParent(result);
        result = buf;
        buf = null;
    }

    /**
     * Append the buf to stack top's child list, then clear the buf
     * If the stack is empty, just push the buf into it
     */
    private void merge() {
        final Statement parent = pop();
        if (parent != null) {
            // Add the buf into the child list of parent
            if (parent instanceof ChildrenAppendable) {
                try {
                    ((ChildrenAppendable) parent).append(buf);
                } catch (IllegalArgumentException iae) {
                    throw new SyntaxException(iae, "'%s' mustn't contain substatement '%s' in line %d!",
                            NameUtil.java2Yang(parent.getClass()), NameUtil.java2Yang(buf.getClass()), currentLine);
                }
                buf.setParent(parent);
                buf = parent;
                buf.setParent(null);
            } else {
                throw new SyntaxException("'%s' mustn't contain any substatement, but '%s' found before line %d!",
                        NameUtil.java2Yang(parent.getClass()), NameUtil.java2Yang(buf.getClass()), currentLine);
            }
            // Set buf = parent
            buf = parent;
        }
        // Push the buf to the stack;
        push();
    }

    /**
     * Pop one statement from the stacks
     */
    private Statement pop() {
        Statement top = result;
        if (top == null) return null;
        result = result.getParent();
        top.setParent(null);
        return top;
    }

    private void init() {
        currentLine = 1;
        buf = null;
        result = null;
        commentParser.initialize();
    }
}
