package com.groovy.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class B2bModel extends AbstractB2bContactRequest implements Serializable {

    private String certificateNumber;

    private LocalDateTime certificateDate;

    private String manufacturerName;

    private String customerName;

    private String address;

    private String customerMobilePhone;

    private String customerHomePhone;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime registrationDate;

    private String service;

    private Status status;

    private ContactB2bDictionary warrantyType;

    @JsonProperty("type")
    private ContactB2bDictionary requestType;

    @JsonProperty("isChanged")
    private Boolean changed;

    private ContactB2bDictionary goods;

    private Long cityId;

    private Long streetId;

    private String house;

    private String entrance;

    private String floor;

    private String apartment;

    @JsonProperty("massageCount")
    private Integer messagesCount;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliveryGoodsDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime sellGoodsDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime placePreparationDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime postponedTillDate;

    private Long brigadeId;

    private Long serviceCenterId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime implementationStartDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime implementationEndDate;

    private String fault;

    private String comment;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime insuranceCaseDate;

    private String insuranceCaseComments;

    private List<B2bQuestionnaire> questionnaire;

    private List<B2bMessage> messages = new ArrayList<>();

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class Status extends ContactB2bDictionary {

        private boolean canChange = false;
    }
}
