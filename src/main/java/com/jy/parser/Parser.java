package com.jy.parser;

import com.jy.lang.node.Statement;

/**
 * Parser of YANG schema
 * The lexical grammar:
 * <p>
 * R -> T+S+T+N+T+B
 * B -> \t| |
 *
 * @author zhy
 */
public class Parser {
    /**
     * parse one statement
     * <statement type> <statement name> {
     * <statement content>
     * }
     *
     * @param schema schema script
     * @param <T>    schema type
     * @return data
     */
    public <T extends Statement> T parse(String schema) {
        T result;
        schema.chars().forEach(c -> {

        });
    }
}
