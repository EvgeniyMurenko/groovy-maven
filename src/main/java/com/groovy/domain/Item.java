package com.groovy.domain;

import org.apache.commons.lang3.StringUtils;

public class Item {

    private String code;
    private String description;

    public Item(String code, String description) {
        this.code = code.replaceAll("[^0-9.\\s]|([^0-9]\\.[^0-9])+", "");
        this.description = StringUtils.abbreviate(description, 250);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
