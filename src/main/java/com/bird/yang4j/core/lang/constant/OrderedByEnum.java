package com.bird.yang4j.core.lang.constant;

/**
 * Section 7.7.5
 * Defined the order of entries within a list are determined by the user or the system
 */
public enum OrderedByEnum {
    system, user;
    public static OrderedByEnum DEFAULT = system;
}
