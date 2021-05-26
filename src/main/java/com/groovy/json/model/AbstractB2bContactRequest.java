package com.groovy.json.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class AbstractB2bContactRequest {

    private Long id;
}
