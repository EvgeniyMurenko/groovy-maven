package com.groovy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.TypeRef;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FromJson {

    public static void main(String[] args) throws JsonProcessingException {

        String str = "{\"parameters\":[{\"PARAM_0\":\"1\"}]}";

        Map<String, Object> map = Map.of("parameters", List.of(Map.of("PARAM_0", 1)));

        Formatter f = new Formatter();
        List<Map<String, Object>> result = f.getResult(map);
        System.out.println(result);

    }


}
