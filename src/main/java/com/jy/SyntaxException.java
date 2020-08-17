package com.jy;

/**
 *
 */
public class SyntaxException extends Exception {
    public SyntaxException() {
        this("LEX ERROR");
    }

    public SyntaxException(String message) {
        super(message);
    }

    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
}
