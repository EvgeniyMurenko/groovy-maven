package com.groovy.justin;

import java.math.BigDecimal;

public class MainJustin {


    public static void main(String[] args) {


        JustinApiClient client = new JustinApiClient();

        client.getDeliveryPrice(1L, 1L, BigDecimal.ONE, BigDecimal.valueOf(100L), BigDecimal.valueOf(100L), true );

    }
}
