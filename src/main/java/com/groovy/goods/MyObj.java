package com.groovy.goods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyObj {

    @JsonProperty("hits")
    private Hits hits;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hits {

        @JsonProperty("hits")
        private List<Hits1> hits1s;
    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hits1 {
        @JsonProperty("_source")
        private Goods source;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Goods {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;
    }
}
