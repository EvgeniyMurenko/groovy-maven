package com.groovy.json;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class MainContextPathSet {

    public static void main(String[] args) {

        String json = "{\"rootRequest\": null, \"rootRequestB2B\": 12461599}";

        Configuration jsonConfig = Configuration.builder()
                .options(Option.DEFAULT_PATH_LEAF_TO_NULL, Option.SUPPRESS_EXCEPTIONS)
                .build();

        DocumentContext documentContext = JsonPath.parse(json, jsonConfig);


        String jayPath = "$.author";
        String tagValue = "ReplacedText";

        documentContext.set(jayPath, tagValue);

        System.out.println(documentContext.jsonString());

    }
}
