package com.bird.yang4j.core.lang.constant;

/**
 * Section 7.19.2
 * Argument enum set of status statement
 */
public enum StatusEnum {

    /**
     * "current" means that the definition is current and valid.
     * If no status is specified, the default is "current".
     */
    current,
    /**
     * "deprecated" indicates an obsolete definition, but it permits new/continued implementation
     * in order to foster interoperability with older/existing implementations
     */
    deprecated,
    /**
     * "obsolete" means the definition is obsolete and SHOULD NOT be implemented and/or
     * can be removed from implementations.
     */
    obsolete;

    public static StatusEnum DEFAULT = current;
}
