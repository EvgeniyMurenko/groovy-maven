package com.groovy.novaPochta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.groovy.novaPochta.utils.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewPostApiResponse {

    private Boolean success;

    private List<DeliveryDateItem> data;

    private List<String> errors;
    private List<String> warnings;
    private List<String> info;
    private List<String> messageCodes;
    private List<String> errorCodes;
    private List<String> warningCodes;
    private List<String> infoCodes;

    @Data
    public static class DeliveryDateItem {

        @JsonProperty("DeliveryDate")
        private DeliveryDate deliveryDate;
    }

    @Data
    public static class DeliveryDate {

        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime date;

        @JsonProperty("timezone_type")
        private String timezoneType;

        @JsonProperty("timezone")
        private String timeZone;
    }
}
