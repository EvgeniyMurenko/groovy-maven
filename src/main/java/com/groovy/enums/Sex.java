package com.groovy.enums;

public enum Sex {

    ЖІНОЧА("Жіноча_1"),
    ЧОЛОВІЧА("Чоловіча_2");

    private String value;

    Sex(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Sex fromValue(String v) {
        for (Sex c: Sex.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
