package com.groovy.haveSamePropertyValues;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Model {

    private Long id;

    private String value;

    private String other;

    private Boolean isBool;

    private Long cityId;

    public Model(Long id, String value, String other, Boolean isBool, Long cityId) {
        this.id = id;
        this.value = value;
        this.other = other;
        this.isBool = isBool;
        this.cityId = cityId;
    }
}
