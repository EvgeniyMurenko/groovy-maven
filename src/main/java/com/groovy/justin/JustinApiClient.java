package com.groovy.justin;

import com.groovy.justin.model.JustinCostRequestDto;
import com.groovy.justin.model.JustinCostResponseDto;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Log4j2
public class JustinApiClient {

    private static final String GET_DELIVERY_DATE_PATH = "/getDocumentPrice";

    private final String baseUrl = "http://api.justin.ua/justin_pms_test/hs/v2/runRequest";
    private final String keyAccount = "Just";
    private final String sign = "Just";
    private final String apiKey = "f2290c07-c028-11e9-80d2-525400fb7782";


    public JustinCostResponseDto getDeliveryPrice(Long cityFromId, Long cityToId, BigDecimal weight, BigDecimal cost, BigDecimal amount, Boolean needPaymentDelivery) {
        if (Objects.isNull(weight) || weight.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("Weight is less than or equals 0");
        }

        String cityFromRef = "bdd500f0-dbfd-11e7-80c6-00155dfbfb00";
        String cityToRef = "2e90798c-dbfd-11e7-80c6-00155dfbfb00";

        JustinCostRequestDto.MethodParams params = new JustinCostRequestDto.MethodParams(cityFromRef, cityToRef, cost, apiKey,
                LocalDateTime.now(), amount, needPaymentDelivery, 1, weight);

        JustinCostRequestDto body =
                new JustinCostRequestDto(keyAccount, encryptPassword(), "getData", "request", "getCalculateData", params);

        return getPriceFromApi(body);
    }

    private String encryptPassword() {
        return DigestUtils.sha1Hex(sign + ":" + LocalDate.now());
    }

    private JustinCostResponseDto getPriceFromApi(JustinCostRequestDto body) {

        URI url = UriComponentsBuilder.fromUriString(baseUrl)
                .path(GET_DELIVERY_DATE_PATH)
                .build().toUri();

        JustinCostResponseDto result = WebClient.builder().build()
                .post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(JustinCostResponseDto.class)
                .block();

//        return result.map(dto -> {
//            if (!CollectionUtils.isEmpty(dto.getErrors())) {
//                log.error("Errors = {}", dto.getErrors());
//                throw new IllegalStateException("New Post API responced with errors: " + dto.getErrors().toString());
//            }
//            return dto.getData().stream()
//                    .map(costItem -> {
//                        BigDecimal cost = Optional.ofNullable(costItem.getCost()).orElse(BigDecimal.ZERO);
//                        BigDecimal costRedelivery = Optional.ofNullable(costItem.getCostRedelivery()).orElse(BigDecimal.ZERO);
//                        return cost.add(costRedelivery);
//                    })
//                    .reduce(BigDecimal::add)
//                    .orElse(BigDecimal.ZERO);
//        });

        return result;
    }
}
