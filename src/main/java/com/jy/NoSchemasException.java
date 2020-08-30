package com.jy;

public class NoSchemasException extends RuntimeException {
    public NoSchemasException() {
        super("No schemas!");
    }
}
