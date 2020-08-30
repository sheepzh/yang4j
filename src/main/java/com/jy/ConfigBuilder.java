package com.jy;

import com.jy.parser.SchemasParser;
import com.jy.parser.comment.CommentParser;

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
