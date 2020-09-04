package com.bird.yang4j.core;

import com.bird.yang4j.core.parser.SchemasParser;
import com.bird.yang4j.core.parser.comment.CommentParser;

/**
 * Builder of config
 */
public class ConfigBuilder {

    private final Config config;

    public ConfigBuilder() {
        config = new Config();
    }

    public ConfigBuilder setCommentParser(CommentParser commentParser) {
        config.commentParser = commentParser;
        return this;
    }

    public ConfigBuilder setSchemasParser(SchemasParser schemasParser) {
        config.schemasParser = schemasParser;
        return this;
    }
}
