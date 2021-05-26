package com.groovy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsMessageDTO {

    private Long id;

    @NotBlank
    private String phone;

    private Long templateId;

    private List<Parameter> parameters;

    private String smsText;

    private String viberText;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Parameter {
        @NotBlank
        private String name;

        @NotNull
        private Object value;
    }
}
