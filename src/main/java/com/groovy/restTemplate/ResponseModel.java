package com.groovy.restTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel implements Serializable {

    @JsonProperty("result")
    private List<ContactRequest> result;

    @JsonProperty("errors")
    private List errors;

    @JsonProperty("isSucceeded")
    private Boolean succeeded;

    @JsonProperty("message")
    private String message;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContactRequest {

        @JsonProperty("id")
        private Long id;

        private String certificateNumber;

        @JsonDeserialize(using = DateConverter.class)
        private LocalDateTime certificateDate;

        private String manufacturerName;

        private String goodsName;

        private String goodsModel;

        private String goodsSerial;

        private String customerFIO;

        private String address;

        private String customerPhone;

        @JsonDeserialize(using = DateConverter.class)
        private LocalDateTime registerDate;

        private String service;

        private String note;

        private String status;

        private Boolean isChanged;
    }
}
