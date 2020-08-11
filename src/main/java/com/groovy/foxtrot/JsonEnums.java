package com.groovy.foxtrot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public enum JsonEnums {
    DOCUMENT_TYPE ("[{id:1, value: \"test1\"}, {id:2, value: \"test2\"}]"),
    COUNTY("[{id:1, value: \"country1\"}, {id:2, value: \"country2\"}]");

    @Getter
    private final String value;

    public static JsonEnums of(String name) {
        if (StringUtils.isBlank(name)) {
            throw new NullPointerException("Dictionary name must not be null");
        }

        for (JsonEnums dict : values()) {
            if (dict.name().equalsIgnoreCase(name)) {
                return dict;
            }
        }
        throw new IllegalArgumentException("Dictionary context " + name + " not found");
    }
}
