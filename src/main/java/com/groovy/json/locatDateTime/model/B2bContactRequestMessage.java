package com.groovy.json.locatDateTime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.groovy.json.locatDateTime.utils.LocalDateTimeDeserializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class B2bContactRequestMessage extends AbstractB2bContactRequest implements Serializable {

    private Long id;

    private Long repairRequestId;

    private Long typeId;

    private String typeName;

    private String comment;

    private String userId;

    private String userName;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;

    private LocalDateTime waitTillDate;

    private LocalDateTime registrationDate;

    private ContactRequestDictionary subType;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContactRequestDictionary {

        @JsonProperty("subtypeId")
        private Long id;

        @JsonProperty("subtypeName")
        private String value;
    }
}
