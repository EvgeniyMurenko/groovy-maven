package com.groovy.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
public class B2bContactJsonDTO implements Serializable {

    private Item item;

    @JsonProperty("declarer")
    private Declarer declarer;

    @JsonProperty("checklist")
    private List<Questionnaire> questionnaire;

    @JsonProperty("timeWindow")
    private TimeWindow timeWindow;

    @JsonProperty("receivedDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime receivedDate;

    @JsonProperty("warrantyType")
    private Long warrantyTypeId;

    private Long damageType;

    private String insuranceCaseComments;

    @JsonProperty("preparationDate")
    private LocalDate placePreparationDate;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        private DictionaryItemDTO goods;
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime receivedDate;
        private CertificateCheckResponse certificateData;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Declarer {
        private String lastName;
        private String firstName;
        private String middleName;
        private String mobilePhone;
        private String email;
        private DictionaryItemDTO city;
        private DictionaryItemDTO street;
        private String house;
        private String entrance;
        private String floor;
        private String flat;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CertificateCheckResponse {
        private boolean isSucceeded;
        private Object errors;
        private CertificateData result;
        private String message;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CertificateData {
        private boolean isValid;
        private Long id;
        private String number;
        private Long typeId;
        private String expDate;
        private boolean isActive;
        private boolean isBrigadeJob;
        private String owner;
        private String returnDate;
        private String sellDate;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Questionnaire {
        private Long id;
        private String text;
        private boolean answer;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimeWindow {
        @JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
        private LocalDateTime to;
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime from;
        private Long brigadeId;
        private String brigadeName;
        private Long serviceCenterId;
    }
}
