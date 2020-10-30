package com.groovy.logistic;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailDTO {
    private Long id;
    private BigDecimal orderedQuantity;
    private BigDecimal priceSite;
    private Long goodId;
}
