package com.groovy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMapMain {


    public static void main(String[] args) {

        Map<String, List<String>> jsonMap = new HashMap<>();
        jsonMap.put("20-2", List.of("declarer.lastName",
                "declarer.firstName",
                "declarer.middleName",
                "declarer.mobilePhone",
                "declarer.city.id",
                "declarer.street.id",
                "declarer.house",
                "declarer.entrance",
                "declarer.floor",
                "declarer.flat"));

        List<Map<String, List<String>>> jsonList = List.of(jsonMap);
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            String json = objectMapper.writeValueAsString(jsonList);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
