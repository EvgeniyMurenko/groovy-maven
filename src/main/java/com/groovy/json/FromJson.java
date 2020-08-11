package com.groovy.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FromJson {

    public static void main(String[] args) {

        /*String str = "[{\"crt_id\":8173,\"crt_name\":\"Страховий платiж МастерСервiс АМ 5 рокiв\",\"crt_price\":3199,\"crt_prior\":0,\"crt_ptype\":\"МастерСервис\",\"crt_type\":\"5 лет\",\"crt_descr_arr\":[]}]";


        ObjectMapper objectMapper = new ObjectMapper();

        try {
            System.out.println(objectMapper.readValue(str, T22SaleServices.class));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        List<Integer> list = null;

        if (!list.isEmpty()){
            System.out.println("list no empty");
            list.forEach(it -> System.out.println("it = "+it));
        } else {
            System.out.println("empty list");
        }
    }
}
