package com.groovy.goods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditResult {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("value")
    private String value;

    @JsonProperty("graces")
    private List<Graces> graces;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Graces {
        @JsonProperty("grace")
        private Long grace;
        @JsonProperty("firstPay")
        private BigDecimal firstPay;
        @JsonProperty("monthPay")
        private BigDecimal monthPay;
    }
}
