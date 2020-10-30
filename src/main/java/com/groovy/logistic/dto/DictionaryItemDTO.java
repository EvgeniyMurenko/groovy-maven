package com.groovy.logistic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties({"address"})
public class DictionaryItemDTO implements Serializable {

    private Long id;

    private String value;
}
