package com.groovy.novaPochta.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewPostApiRequest {

    private String apiKey;

    private String modelName;

    private String calledMethod;

    private MethodProperties methodProperties;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MethodProperties {

        @JsonFormat(pattern = "dd.MM.yyyy")
        @JsonProperty("DateTime")
        private LocalDateTime date;

        @JsonProperty("ServiceType")
        private String serviceType;

        @JsonProperty("CitySender")
        private String cityFrom;

        @JsonProperty("CityRecipient")
        private String cityTo;
    }

    public NewPostApiRequest(String modelName, String calledMethod, LocalDateTime date,
                             String serviceType, String cityFrom, String cityTo) {
        this.modelName = modelName;
        this.calledMethod = calledMethod;
        MethodProperties methodProperties = new MethodProperties();
        methodProperties.setDate(date);
        methodProperties.setServiceType(serviceType);
        methodProperties.setCityFrom(cityFrom);
        methodProperties.setCityTo(cityTo);
        this.methodProperties = methodProperties;
    }
}
