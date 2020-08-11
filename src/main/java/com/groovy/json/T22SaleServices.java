package com.groovy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class T22SaleServices {

    private List<SaleService> services;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SaleService {

        @JsonProperty("crt_id")
        private Long id;

        @JsonProperty("crt_name")
        private String name;

        @JsonProperty("crt_price")
        private BigDecimal price;


        @JsonProperty("crt_prior")
        private Integer prior;

        @JsonProperty("crt_ptype")
        private String ptype;

        @JsonProperty("crt_type")
        private String type;

        @JsonProperty("crt_descr_arr")
        private List<String> descr;
    }
}
