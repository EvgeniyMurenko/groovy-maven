package com.groovy.enums;

public enum Gender {

    /**
     * Чоловіча
     *
     */
    MALE,

    /**
     * Жіноча
     *
     */
    FEMALE;

    public String value() {
        return name();
    }

    public static Gender fromValue(String v) {
        return valueOf(v);
    }

}
