package com.groovy.logistic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"value"})
public class TimeWindowDTO extends DictionaryItemDTO {

    private LocalTime from;

    private LocalTime to;
}
