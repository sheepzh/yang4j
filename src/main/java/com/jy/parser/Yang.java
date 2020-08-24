package com.jy.parser;

import com.jy.SyntaxException;
import com.jy.lang.Statement;
import com.jy.lang.StatementFactory;
import com.jy.util.CharUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Parser of YANG schema
 *
 * @author zhy
 */
public class Yang {

    private final StringBuffer tokens = new StringBuffer();

    private Triple buf = null;

    /**
     * Tail of the triple stack while initializing
     */
    private Triple tail = null;

    private final Statement root;

    /**
     * Current line of schema, for error logging
     */
    private int currentLine = 1;

    private boolean quoted = false;

    public Yang(String schema) throws SyntaxException {
        for (char c : schema.toCharArray()) {
            if (CharUtils.isNotBlank(c)) {
                // Regard blank character between quotes as one token
                if (quoted) {
                    tokens.append(c);
                    continue;
                }
                if (c == '{') {
                    resolveTokens();
                    if (emptyTriple()) {
                        throw new SyntaxException("Need keyword [ argument ] before '{' in line %d!", currentLine);
                    }
                    push();
                } else if (c == ';') {
                    resolveTokens();
                    if (emptyTriple()) {
                        throw new SyntaxException("Need keyword [ argument ] before ';' in line %d!", currentLine);
                    }
                    // Substatements of leaf;
                    Triple parent = pop();
                    if (parent != null) {
                        addChildTo(parent);
                    }
                    push();
                } else if (c == '}') {
                    if (!emptyTriple()) {
                        throw new SyntaxException("Need ';' before '}' in line %d!", currentLine);
                    }
                } else {
                    tokens.append(c);
                }
            } else {
                if (c == '\n') {
                    currentLine++;
                }
                resolveTokens();
            }
        }
        root = generate(this.tail);
        this.buf = null;
    }

    /**
     * Resolve tokens
     */
    private void resolveTokens() {
        if (tokens.length() > 0) {
            if (buf == null) {
                buf = new Triple();
            }
            String word = tokens.toString();
            if (buf.keyword == null) {
                buf.keyword = word;
            } else if (buf.argument == null) {
                buf.argument = word;
            } else {
                // Both keyword and argument have been set
                throw new SyntaxException("Unexpected word in line %d: %s", currentLine, word);
            }
            // Clean the tokens
            tokens.delete(0, tokens.length());
        }
    }

    /**
     * Determines whether buf is invalid.
     *
     * @return true if buf is null, or the statement of buf is blank
     */
    private boolean emptyTriple() {
        return buf == null || buf.keyword == null || "".equals(buf.keyword.trim());
    }

    private void push() {
        if (tail == null) {
            buf.previousNode = null;
        } else {
            buf.previousNode = tail;
        }
        tail = buf;
        buf = null;
    }

    /**
     * Append the buf to {@code parent}'s children, then replace buf with {@code parent}
     *
     * @param parent parent
     */
    private void addChildTo(Triple parent) {
        if (parent.children == null) parent.children = new LinkedList<>();
        parent.children.add(buf);
        buf = parent;
    }

    /**
     * Pop one statement from the stacks
     */
    private Triple pop() {
        Triple result = tail;
        if (result == null) return null;
        tail = tail.previousNode;
        result.previousNode = null;
        return result;
    }

    private Statement generate(Triple triple) {
        StatementFactory factory = StatementFactory.getInstance();
        Statement result = null;
        if (triple != null) {
            result = factory.product(triple.keyword, triple.argument);
            List<Triple> children = triple.children;
            if (children != null && !children.isEmpty()) {
                children.stream().map(this::generate).forEach(result::append);
            }
        }
        return result;
    }

    public Statement getRoot() {
        return root;
    }

    /**
     * The triple of statement in YANG module, including keyword, name, children
     */
    private static class Triple {
        private String keyword;
        private String argument;
        private List<Triple> children;

        /**
         * For stack function
         */
        private Triple previousNode;
    }

    public static void main(String[] s) {
        String schema = "" +
                "rpc activate-software-image {\n" +
                "  input {\n" +
                "    leaf image-name {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "  output {\n" +
                "    leaf status {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String schema2 = "anyxml 23123 {rpc 3123 ; }";
        Yang yang = new Yang(schema2);
        System.out.println(yang.getRoot());
    }
}
