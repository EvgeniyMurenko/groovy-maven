package com.groovy.logistic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties({"address"})
public class DictionaryItemDTO implements Serializable {

    private Long id;

    private String value;
}
