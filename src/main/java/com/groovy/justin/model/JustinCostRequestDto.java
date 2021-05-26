package com.groovy.justin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JustinCostRequestDto {

    private String keyAccount;
    private String sign;
    private String request;
    private String type;
    private String name;
    private MethodParams params;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MethodParams {

        private String cityFrom;
        private String cityTo;
        private BigDecimal COD; //Сума післяплати (в грн).
        private String counterpart; //Ключ відправника (api_key)

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime currentDate;
        private BigDecimal declaredAmount; // Оголошена вартість
        private Boolean needPaymentDelivery; // Необхідність оплати доставки
        private Integer payerDelivery; // Платник доставки: 0 – отримувач; 1 – відправник.
        private BigDecimal weight; // Вага

        public MethodParams(String cityFrom, String cityTo, BigDecimal COD, String counterpart,
                            LocalDateTime currentDate, BigDecimal declaredAmount, Boolean needPaymentDelivery,
                            Integer payerDelivery, BigDecimal weight) {
            this.cityFrom = cityFrom;
            this.cityTo = cityTo;
            this.COD = COD;
            this.counterpart = counterpart;
            this.currentDate = currentDate;
            this.declaredAmount = declaredAmount;
            this.needPaymentDelivery = needPaymentDelivery;
            this.payerDelivery = payerDelivery;
            this.weight = weight;
        }
    }

    public JustinCostRequestDto(String keyAccount, String sign, String request, String type, String name, MethodParams params) {
        this.keyAccount = keyAccount;
        this.sign = sign;
        this.request = request;
        this.type = type;
        this.name = name;
        this.params = params;
    }
}
