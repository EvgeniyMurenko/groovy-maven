package com.groovy.webClient;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class WebClientMain {

    public static void main(String[] args) {


        String r = sent();
        System.out.println(r);
    }

    private static String sent() {


        URI url = UriComponentsBuilder.fromUriString("https://logistics.jbs.com.ua")
                .path("/integration-api-reactive")
                .path("/api/deliveries/calculate")
                .build().toUri();

        return WebClient.builder().build()
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("{\"callTime\":\"2020-08-19T10:52:29.517Z\",\"cityId\":38044,\"saleDetails\":[{\"goodId\":6526547,\"id\":0,\"orderedQuantity\":1,\"priceSite\":0}],\"strategy\":\"T22\"}"))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
