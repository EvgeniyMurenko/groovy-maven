package com.groovy.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class B2bMessage extends AbstractB2bContactRequest implements Serializable {

    private Long id;

    private Long repairRequestId;

    private Long typeId;

    private String typeName;

    private String comment;

    private String userId;

    private String userName;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime waitTillDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime registrationDate;

    private ContactRequestDictionary subType;

    private Long code = null;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContactRequestDictionary {

        @JsonProperty("subtypeId")
        private Long id;

        @JsonProperty("subtypeName")
        private String value;
    }
}
