package com.jy.parser.comment;

import org.junit.Test;

public class CommentSchemasParserTest {
    private final CommentParser parser = new DefaultCommentParser();

    @Test
    public void t1() {
        parser.initialize();

        parser.accept('/');
        assert parser.isOpen();
        parser.accept('/');
        assert parser.isOpen(); // Line note is open
        parser.assertClose(); // Also, line note is closed
        parser.accept('\n'); // Line note is closed
        assert !parser.isOpen();

        parser.accept('/');
        parser.accept('*');
        assert parser.isOpen();
        parser.initialize();
        assert !parser.isOpen(); // Closed after initializing
        parser.accept('/');
        parser.accept('*');
        parser.accept('*');
        parser.accept('/');
        parser.assertClose(); // Segment note is closed
    }

    @Test
    public void t2() {
        parser.initialize();

        String comment = "/**** ****/";
        for (char c : comment.toCharArray()) {
            parser.accept(c);
        }
        assert !parser.isOpen();
    }
}
