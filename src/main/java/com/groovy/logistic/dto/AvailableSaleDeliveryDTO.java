package com.groovy.logistic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.groovy.logistic.utils.LocalDateDeserializer;
import com.groovy.logistic.utils.LocalDateSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class AvailableSaleDeliveryDTO {

    private DictionaryItemDTO shipmentType;

    private DictionaryItemDTO deliveryType;

    private DictionaryItemDTO deliveryKind;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<DateTimeWindowDTO> dateTimeWindows;

    private BigDecimal deliveryTotalCost;

    private BigDecimal deliveryOnFloorCost;
}
