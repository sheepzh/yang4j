package com.jy.lang;

import com.jy.SyntaxException;
import com.jy.util.NameUtil;
import com.jy.util.StringUtils;

/**
 * statement = keyword [argument] (";" /"{" *statement "}" )
 *
 * @author zhy
 */
public interface Statement {

    String getArgument();

    void setArgument(String argument);

    /**
     * Assert that this is one valid statement
     *
     * @throws SyntaxException while not invalid
     */
    default void assertValid() throws SyntaxException {
        if (StringUtils.isBlank(getArgument())) {
            throw new SyntaxException("No argument on the %s statement", NameUtil.java2Yang(this.getClass()));
        }
    }
}
