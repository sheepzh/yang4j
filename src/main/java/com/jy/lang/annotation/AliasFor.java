package com.jy.lang.annotation;

import java.lang.annotation.*;

/**
 * Annotate the alias name as statement name on the statement class.
 *
 * @author zhy
 * @see com.jy.util.NameUtil#java2Yang(Class)
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
