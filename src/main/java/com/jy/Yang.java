package com.jy;

import com.jy.lang.Statement;
import com.jy.parser.Context;
import com.jy.parser.DefaultSchemasParser;
import com.jy.parser.SchemasParser;
import com.jy.parser.comment.CommentParser;
import com.jy.parser.comment.DefaultCommentParser;
import com.jy.util.StringUtils;

/**
 * Parser of YANG schemas
 *
 * @author zhy
 */
public class Yang {

    private final Config config;

    private final Statement root;

    private final String schemas;

    private final Context context = new Context();

    public Yang(String schemas) {
        this(schemas, new Config());
    }

    public Yang(String schemas, Config config) {
        if (config == null) throw new NullPointerException("The config is null!");
        if (StringUtils.isBlank(schemas)) throw new IllegalArgumentException("The schemas can't be null or empty!");

        this.config = config;
        this.schemas = schemas;

        this.root = parse();
    }

    public String getSchemas() {
        return schemas;
    }

    @SuppressWarnings("unchecked")
    public <T extends Statement> T getRoot() {
        return (T) root;
    }

    @SuppressWarnings("unchecked")
    public <T extends Statement> T getRoot(Class<T> clz) {
        return (T) root;
    }

    private Statement parse() {
        SchemasParser schemasParser = config.schemasParser;
        if (schemasParser == null) schemasParser = new DefaultSchemasParser();

        CommentParser commentParser = config.commentParser;
        if (commentParser == null) commentParser = new DefaultCommentParser();

        return schemasParser.setCommentParser(commentParser).parse(schemas);
    }
}
