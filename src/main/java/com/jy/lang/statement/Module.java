package com.jy.lang.statement;

import com.jy.SyntaxException;
import com.jy.lang.AbstractStatement;
import com.jy.lang.Statement;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The module's substatements
 * +--------------+---------+-------------+
 * | subsstatement | section | cardinality |
 * +--------------+---------+-------------+
 * | anyxml        | 7.10    | 0..n        |
 * | augment       | 7.15    | 0..n        |
 * | choice        | 7.9     | 0..n        |
 * | contact       | 7.1.8   | 0..1        |
 * | container     | 7.5     | 0..n        |
 * | description   | 7.19.3  | 0..1        |
 * | deviation     | 7.18.3  | 0..n        |
 * | extension     | 7.17    | 0..n        |
 * | feature       | 7.18.1  | 0..n        |
 * | grouping      | 7.11    | 0..n        |
 * | identity      | 7.16    | 0..n        |
 * | import        | 7.1.5   | 0..n        |
 * | include       | 7.1.6   | 0..n        |
 * | leaf          | 7.6     | 0..n        |
 * | leaf-list     | 7.7     | 0..n        |
 * | list          | 7.8     | 0..n        |
 * | namespace     | 7.1.3   | 1           |
 * | notification  | 7.14    | 0..n        |
 * | organization  | 7.1.7   | 0..1        |
 * | prefix        | 7.1.4   | 1           |
 * | reference     | 7.19.4  | 0..1        |
 * | revision      | 7.1.9   | 0..n        |
 * | rpc           | 7.13    | 0..n        |
 * | typedef       | 7.3     | 0..n        |
 * | uses          | 7.12    | 0..n        |
 * | yang-version  | 7.1.2   | 0..1        |
 * +--------------+---------+-------------+
 *
 * @author zhy
 */
public class Module extends AbstractStatement {
    public final static String KEYWORD = "module";


    @Override
    public <T extends Statement> void append(T statement) throws SyntaxException, NullPointerException {

    }
}
