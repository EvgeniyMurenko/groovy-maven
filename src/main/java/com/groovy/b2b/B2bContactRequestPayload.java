package com.groovy.b2b;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class B2bContactRequestPayload {

    @JsonProperty("FIO")
    private String fullName;

    @JsonProperty("StatusId")
    private Long statusId;

    @JsonProperty("RegisterDate")
    private LocalDateTime registerDate;

    @JsonProperty("RR_IS_ACTIVE")
    private String applicationActivityStatus;

    @JsonProperty("RR_CREATOR_ID")
    private List<Long> applicationAuthorIds;

    @JsonProperty("HomePhone")
    private String homePhone;

    @JsonProperty("SUM_REMAIN")
    private String sumRemain;

    @JsonProperty("TypeId")
    private Long typeId;

    @JsonProperty("rr_archived")
    private String archived;

    @JsonProperty("ServiceCenterId")
    private Long serviceCenterId;

}
