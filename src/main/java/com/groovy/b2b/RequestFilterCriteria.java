package com.groovy.b2b;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestFilterCriteria {

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;
}
