package com.groovy.goods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Product {
    private Long actionId;
    private BigDecimal bonus;
    private Long id;
    private BigDecimal price;
    private Integer qty;
    private BigDecimal realPrice;
    private List<CreditResult> graceResults = new ArrayList<>();
}
