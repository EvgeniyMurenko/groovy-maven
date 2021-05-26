package com.groovy.serializable;

import lombok.Data;
import lombok.ToString;


import java.io.Serializable;

@Data
@ToString
public class MyObject implements Serializable {
    private Long id;
    private String value;

    public MyObject(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
