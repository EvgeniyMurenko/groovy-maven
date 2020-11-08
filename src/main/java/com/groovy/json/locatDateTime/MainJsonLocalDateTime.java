package com.groovy.json.locatDateTime;

import com.groovy.json.locatDateTime.model.B2bContactRequestMessage;
import com.groovy.json.locatDateTime.model.RestService;

public class MainJsonLocalDateTime {

    public static void main(String[] args) {

        RestService restService = new RestService();

        B2bContactRequestMessage result = restService.getResult();

        System.out.println(result);
    }


}
