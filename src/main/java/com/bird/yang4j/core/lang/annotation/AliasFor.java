package com.bird.yang4j.core.lang.annotation;

import com.bird.yang4j.core.util.NameUtil;

import java.lang.annotation.*;

/**
 * Annotate the alias name as statement name on the statement class.
 *
 * @author zhy
 * @see NameUtil#java2Yang(Class)
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.TYPE, ElementType.FIELD})
@Documented
public @interface AliasFor {
    /**
     * @return alias name
     */
    String value();
}
