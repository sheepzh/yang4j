package com.jy.parser;

import com.jy.parser.note.DefaultNoteParser;
import org.junit.Test;

public class NoteParserTest {
    private final NoteParser parser = new DefaultNoteParser();

    @Test
    public void t1() {
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
}
