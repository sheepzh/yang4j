package com.jy;

import com.jy.lang.ChildrenAppendable;
import com.jy.lang.Statement;
import com.jy.lang.StatementFactory;
import com.jy.lang.statement.Anyxml;
import com.jy.lang.statement.Rpc;
import com.jy.parser.comment.CommentParser;
import com.jy.parser.comment.DefaultCommentParser;
import com.jy.util.CharUtils;
import com.jy.util.NameUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Parser of YANG schemas
 *
 * @author zhy
 */
public class Yang {

    /**
     * Parser of comment
     */
    private CommentParser commentParser;

    private String schemas;

    private final StringBuilder tokens = new StringBuilder();

    private Triple buf;
    /**
     * Tail of the triple stack while initializing
     */
    private Triple tail = null;

    private Statement root = null;

    /**
     * Current line of schemas, for error logging
     */
    private int currentLine = 1;

    public Yang() {
        this(new DefaultCommentParser());
    }

    public Yang(CommentParser commentParser) {
        this.commentParser = commentParser;
    }

    public Yang compile() {
        init();
        boolean quoted = false;
        for (char c : schemas.toCharArray()) {
            if (c == '\n') currentLine++;
            // double quote
            if (quoted) {
                if (c == '"') quoted = false;
                else tokens.append(c);
                continue;
            }
            // note
            if (commentParser.accept(c).isOpen()) {
                continue;
            }
            if (CharUtils.isNotBlank(c)) {
                // Regard blank character between quotes as one token
                if (c == '{') {
                    reduce();
                    if (emptyTriple()) {
                        throw new SyntaxException("Need keyword [ argument ] before '{' in line %d!", currentLine);
                    }
                    push();
                } else if (c == ';') {
                    reduce();
                    if (emptyTriple()) {
                        throw new SyntaxException("Need keyword [ argument ] before ';' in line %d!", currentLine);
                    }
                    // Substatements of leaf;
                    merge();
                } else if (c == '}') {
                    if (!emptyTriple()) {
                        throw new SyntaxException("Need ';' before '}' in line %d!", currentLine);
                    }
                    // Current statement is over, then pop it and add it into the parent's child list
                    buf = pop();
                    merge();
                } else if (c == '"') {
                    quoted = true;
                } else {
                    tokens.append(c);
                }
            } else {
                reduce();
            }
        }
        commentParser.assertClose();
        this.root = build0(this.tail);
        this.root.assertValid();
        return this;
    }

    private void init() {
        currentLine = 1;
        commentParser.initialize();
        buf = null;
        tail = null;
        root = null;
    }

    /**
     * Reduce tokens to the argument or the keyword
     */
    private void reduce() {
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
                throw new SyntaxException("Unexpected word in line %d: %s!", currentLine, word);
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
     * Append the buf to stack top's child list, then clear the buf
     * If the stack is empty, just push the buf into it
     */
    private void merge() {
        Triple parent = pop();
        if (parent != null) {
            // Add the buf into the child list of parent
            if (parent.children == null) parent.children = new LinkedList<>();
            parent.children.add(buf);
            // Set buf = parent
            buf = parent;
        }
        // Push the buf to the stack;
        push();
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

    private Statement build0(Triple triple) {
        StatementFactory factory = StatementFactory.getInstance();
        Statement result = null;
        if (triple != null) {
            result = factory.product(triple.keyword, triple.argument);
            List<Triple> children = triple.children;
            if (children != null && children.size() > 0) {
                if (result instanceof ChildrenAppendable) {
                    ChildrenAppendable appendable = (ChildrenAppendable) result;
                    children.stream().map(this::build0).forEach(appendable::append);
                } else {
                    throw new SyntaxException("'%s' mustn't contain any substatements, but found in the schemas",
                            NameUtil.java2Yang(result.getClass())
                    );
                }
            }
        }
        return result;
    }

    public CommentParser getCommentParser() {
        return commentParser;
    }

    public Yang setCommentParser(CommentParser commentParser) {
        this.commentParser = commentParser;
        return this;
    }

    public String getSchema() {
        return schemas;
    }

    public Yang setSchemas(String schemas) {
        this.schemas = schemas;
        this.init();
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getRoot() {
        if (root == null) {
            throw new RuntimeException();
        }
        return (T) root;
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

        @Override
        public String toString() {
            return "Triple{" +
                    "keyword='" + keyword + '\'' +
                    ", argument='" + argument + '\'' +
                    '}';
        }
    }

    public static void main(String[] s) {
        String schemas = "" +
                "rpc activate-software-image {\n" +
                "  input {\n" +
                "    leaf image-name {\n" +
                "      type string;\n" +
                "    }\n" +
                "  }\n" +
                "  output {\n" +
                "    leaf status {\n" +
                "      type boolean;\n" +
                "      default true;" +
                "    }\n" +
                "  }\n" +
                "}";
        String schemas2 = "anyxml 23123 { config \"true\" ; }";

        Yang yang = new Yang();
        Rpc rpc = yang.setSchemas(schemas).compile().getRoot();
        Anyxml anyxml = yang.setSchemas(schemas2).compile().getRoot();
    }
}
