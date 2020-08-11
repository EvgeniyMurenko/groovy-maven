package com.groovy.tree;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


@ToString
@Data
public class ServiceType {

    private Long id;

    private String name;

    private BigDecimal price;

    private Integer priority;

    private String parentTypeName;

    private String typeName;
}
