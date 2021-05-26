package com.groovy.json.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class B2bQuestionnaire implements Serializable {

    private Long repairRequestId;

    private Long questionId;

    private String questionText;

    @NotNull
    private Boolean answerValue;

    @JsonAlias(value = "comment")
    private String answerNote;
}
