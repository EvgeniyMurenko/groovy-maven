package com.groovy.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainEnum {

    public static void main(String[] args) {

//        Map<String, Integer> result = new HashMap<>();
//        for (SaleStatus saleStatus : SaleStatus.values()){
//            result.put(saleStatus.name(), saleStatus.ordinal());
//        }
//
//        System.out.println(result.toString());


        boolean contains = List.of(SaleType.WEB, SaleType.RETAIL).contains(SaleType.valueOf("WEB"));
        System.out.println(contains);

        System.out.println(Set.of(1,2,3).containsAll(Set.of(1,2,3,4)));

    }
}
