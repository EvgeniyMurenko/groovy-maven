package com.groovy.time;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Main {

    public static void main(String[] args) {


//        LocalTime localTime = LocalTime.parse( "00:01:33" );
//
//        System.out.println(localTime.getLong(ChronoField.NANO_OF_DAY));
//
//
//        BigDecimal bonus = BigDecimal.valueOf(350);
//        BigDecimal coast = BigDecimal.valueOf(300);
//
//        System.out.println(bonus.subtract(coast));
//        if (bonus.subtract(coast).doubleValue() > 1){
//            System.out.println("> 0");
//        } else {
//            System.out.println("< 0");
//        }


        String text = "Each merchant can carry 5000 units of resource";
        String valText = text.replaceAll("\\D", "");

        Integer val = Integer.parseInt(valText);
        System.out.println(val);
    }
}
