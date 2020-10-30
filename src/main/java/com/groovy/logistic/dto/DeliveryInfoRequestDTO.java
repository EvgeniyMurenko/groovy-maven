package com.groovy.logistic.dto;

import com.groovy.logistic.ProcessingStrategy;
import com.groovy.logistic.SaleDetailDTO;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Data
public class DeliveryInfoRequestDTO {

    @NotNull
    private Long cityId;

    @Valid
    @NotEmpty
    private List<SaleDetailDTO> saleDetails;

    private ProcessingStrategy strategy;

    private Instant callTime;
}
