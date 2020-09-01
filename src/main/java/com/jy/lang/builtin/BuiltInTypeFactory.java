package com.jy.lang.builtin;

import com.jy.lang.annotation.AliasFor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 */
public class BuiltInTypeFactory {
    private final Map<String, BuiltInType<?>> allBuiltInType = new HashMap<>();

    private static BuiltInTypeFactory instance;

    private BuiltInTypeFactory() {
        // All enum fields
        Field[] fields = BuiltInType.class.getDeclaredFields();
        for (Field f : fields) {
            if (f.getType().equals(BuiltInType.class)) {
                AliasFor aliasFor = f.getAnnotation(AliasFor.class);
                String yangTxt;
                if (aliasFor != null) {
                    yangTxt = aliasFor.value();
                } else {
                    yangTxt = f.getName().toLowerCase();
                }
                f.setAccessible(true);
                try {
                    allBuiltInType.put(yangTxt, (BuiltInType<?>) f.get(BuiltInType.class));
                } catch (IllegalAccessException e) {
                    // Never happen
                    e.printStackTrace();
                }
            }
        }
    }

    public static BuiltInTypeFactory getInstance() {
        if (instance == null) {
            synchronized (BuiltInTypeFactory.class) {
                if (instance == null) {
                    instance = new BuiltInTypeFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Get the BuiltInType instance as the text in YANG schema
     *
     * @param yangText YANG text
     * @return instance or null
     */
    public BuiltInType<?> product(String yangText) {
        return allBuiltInType.get(yangText);
    }
}
