package com.groovy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class Formatter {

    private final ObjectMapper objectMapper;

    public Formatter() {
        this.objectMapper = new ObjectMapper();
    }


    public List getResult(Map<String, Object> map) {

        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);

        List parameters = getNullSafe(json, "$['parameters']", List.class);
//        String parameters = "[{\"PARAM_0\":\"1\"}]";

        return parameters;
    }

    private <T> T getNullSafe(String json, String path, Class<T> tClass) {
        Configuration jsonConfig = Configuration.builder()
                .options(Option.DEFAULT_PATH_LEAF_TO_NULL, Option.SUPPRESS_EXCEPTIONS)
                .build();
        DocumentContext jsonContext = JsonPath.parse(json, jsonConfig);
        if (StringUtils.isBlank(path)) return null;
        try {
            return jsonContext.read(path, tClass);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> T fromJson(String json, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(json)) return null;
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
