package com.groovy.b2b;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groovy.b2b.model.ConfigDTO;

import java.util.List;

public class MainConfig {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();


        ConfigDTO configDTO1 = ConfigDTO.getDefault("default");
        ConfigDTO configDTO2 = ConfigDTO.getInsurance("insurance");
        try {
            String json1 = objectMapper.writeValueAsString(configDTO1);
            String json2 = objectMapper.writeValueAsString(configDTO2);
            System.out.println(List.of(json1, json2));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
