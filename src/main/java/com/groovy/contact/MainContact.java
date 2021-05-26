package com.groovy.contact;

import java.util.Arrays;
import java.util.List;

public class MainContact {


    public static void main(String[] args) {
        ContactEntity saleEntity = new ContactEntity(484621L, 1557L, (short) 3,
                118959675L, "RETAIL", (short) 1);


        List.of(saleEntity).stream()
                .filter(it -> Arrays.asList(SaleType.values()).contains(SaleType.valueOf(it.getEntityRefKey())))
                .findFirst()
                .ifPresent(System.out::println);
    }

    public enum SaleType {
        WEB, RETAIL
    }
}
