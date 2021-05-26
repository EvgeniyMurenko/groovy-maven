package com.groovy.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.groovy.logistic.dto.DictionaryItemDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestModel {

    @NotBlank
    private String certificateNumber;

    @NotBlank
    private String customerName;

    @NotNull
    private String customerMobilePhone;

    private String customerHomePhone;

    @NotNull
    private Long cityId;

    @NotNull
    private Long streetId;

    @NotBlank
    private String house;

    @NotBlank
    private String entrance;

    @NotBlank
    private String floor;

    @NotBlank
    private String apartment;

    private DictionaryItemDTO status;

    @NotNull
    private DictionaryItemDTO type;

    private LocalDateTime insuranceCaseDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliveryGoodsDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime placePreparationDate;

    private String insuranceCaseComments;

    @NotNull
    private DictionaryItemDTO warrantyType;

    private Long brigadeId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime implementationStartDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime implementationEndDate;

//    private List<QuestionnaireDTO> questionnaire;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime postponedTillDate;

    private DictionaryItemDTO goods;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime registrationDate;

    private Long serviceTypeId;

    private String fault;

    private String comment;

    private Long serviceCenterId;

    private LocalDateTime sellGoodsDate;
}
