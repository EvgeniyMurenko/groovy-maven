package com.groovy.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryItemDTO  implements Serializable {

    private Long id;

    private String name;
}
