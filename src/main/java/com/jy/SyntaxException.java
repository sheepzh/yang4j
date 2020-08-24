package com.jy;

/**
 *
 */
public class SyntaxException extends RuntimeException {
    public SyntaxException() {
        this("SYNTAX ERROR");
    }

    public SyntaxException(String message, Object... args) {
        super(String.format(message, args));
    }

    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
}
