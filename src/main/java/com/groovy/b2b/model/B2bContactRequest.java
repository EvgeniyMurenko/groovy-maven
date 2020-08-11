package com.groovy.b2b.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class B2bContactRequest {

    private List<ContactRequest> result;

    private List<Object> errors;

    @JsonProperty("isSucceeded")
    private Boolean succeeded;

    private String message;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContactRequest {

        private Long id;

        private String certificateNumber;

        private String manufacturerName;

        private String goodsName;

        private String goodsModel;

        private String goodsSerial;

        private String customerFIO;

        private String address;

        private String customerPhone;

        private String service;

        private String note;

        private String status;

        @JsonProperty("isChanged")
        private Boolean changed;
    }
}
