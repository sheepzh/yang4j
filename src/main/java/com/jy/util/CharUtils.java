package com.jy.util;

public class CharUtils {
    public static boolean isNotBlank(char c) {
        return c != ' ' && c != '\t' && c != '\r' && c != '\n';
    }
}
