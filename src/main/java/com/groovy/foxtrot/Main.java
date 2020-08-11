package com.groovy.foxtrot;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Main {
    
    
    public static void main(String[] args) {

        List<DictionatyItem> result = (List<DictionatyItem>) createList("COUNTY");
        System.out.println(result);
        
    }

    private static DictionatyItem createList(String country) {

        String value = JsonEnums.valueOf(country).getValue();
        ObjectMapper mapper = new ObjectMapper();


        try {
            return mapper.readValue(value, DictionatyItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
