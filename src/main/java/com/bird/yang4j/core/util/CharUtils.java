package com.bird.yang4j.core.util;

public class CharUtils {
    public static boolean isNotBlank(char c) {
        return c != ' ' && c != '\t' && c != '\r' && c != '\n';
    }
}
