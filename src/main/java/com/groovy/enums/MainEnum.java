package com.groovy.enums;

import java.util.HashMap;
import java.util.Map;

public class MainEnum {

    public static void main(String[] args) {

        Map<String, Integer> result = new HashMap<>();
        for (SaleStatus saleStatus : SaleStatus.values()){
            result.put(saleStatus.name(), saleStatus.ordinal());
        }

        System.out.println(result.toString());
    }
}
