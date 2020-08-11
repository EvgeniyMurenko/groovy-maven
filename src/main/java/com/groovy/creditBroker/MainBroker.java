package com.groovy.creditBroker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

public class MainBroker {

    public static void main(String[] args) {

        String startPath = "$contact][residenceAddress]";

        String result = String.format("%s['city']['value']", startPath);

        System.out.println(result);
    }
}
