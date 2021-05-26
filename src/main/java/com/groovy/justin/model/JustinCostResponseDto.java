package com.groovy.justin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.groovy.novaPochta.utils.LocalDateTimeDeserializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JustinCostResponseDto {

    private JustinResponse response;
    private Integer totalCountRecords;
    private List<DataList> data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class JustinResponse {
        private Boolean status;
        private String codeError;
        private String message;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataList {
        private DataField fields;
        private List<String> listDataFields;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataField {
        private FieldService service;
        private BigDecimal sum;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FieldService {
        private String uuid;
        @JsonProperty("descr")
        private String description;
        private String type;
    }


}
