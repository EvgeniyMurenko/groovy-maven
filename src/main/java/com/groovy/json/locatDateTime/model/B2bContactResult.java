package com.groovy.json.locatDateTime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class B2bContactResult<T extends AbstractB2bContactRequest> {

    private T result;

    private List<Object> errors;

    @JsonProperty("isSucceeded")
    private Boolean succeeded;

    private String message;
}
