package com.groovy;

import java.math.BigDecimal;

public class MyBigDecimal {

    public static void main(String[] args) {

        BigDecimal value = BigDecimal.valueOf(110.5);

        System.out.println(value.multiply(BigDecimal.valueOf(2)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
}
