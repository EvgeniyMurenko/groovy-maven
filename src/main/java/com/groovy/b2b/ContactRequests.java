package com.groovy.b2b;

import com.groovy.b2b.model.B2bContactRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class ContactRequests {

    private static final String GET_REPAIR_REQUESTS_URL_PATH = "/Integration/GetRepairRequests";
    private static final String UPDATE_REPAIR_REQUESTS_URL_PATH = "/Integration/UpdateRepairRequest";

    private static final Supplier<LocalDateTime> DEFAULT_DATE_FROM_SUPPLIER = () -> LocalDateTime.now().minus(30L, ChronoUnit.DAYS);
    private static final Supplier<LocalDateTime> DEFAULT_DATE_TO_SUPPLIER =() -> LocalDateTime.now().plus(1L, ChronoUnit.DAYS);
    private static final DateTimeFormatter API_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private static final int PHONE_MIN_LENGTH = 10;


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();


        RequestFilterCriteria criteria = setDefaults(null);
        URI url = UriComponentsBuilder.fromUri((URI.create("https://b2b-webapi-test.nash-service.com.ua")))
            .path(GET_REPAIR_REQUESTS_URL_PATH)
            .queryParam("fullresponse", Boolean.TRUE.toString())
            .queryParam("dateFrom", formatToApiDate(criteria.getDateFrom()))
            .queryParam("dateTo", formatToApiDate(criteria.getDateTo()))
            .build().toUri();

        System.out.println(url.toString());
        HttpHeaders headers = createHeaders();
        ResponseEntity<B2bContactRequest> exchange;
        try {
            exchange = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), B2bContactRequest.class);
        } catch (HttpStatusCodeException e) {
            String msg = String.format("Failed to get requests by dateFrom: %s dateTo: %s. Response status: %s, body: %s", formatToApiDate(criteria.getDateFrom()), formatToApiDate(criteria.getDateTo()),
                e.getStatusCode().toString(), e.getResponseBodyAsString());
            System.out.println(msg +" - " + e);
            return;
        }

        if(!CollectionUtils.isEmpty(Objects.requireNonNull(exchange.getBody()).getErrors())){
            return;
        }

        List<B2bContactRequest.ContactRequest> result = exchange.getBody().getResult().stream()
                .filter(request -> StringUtils.length(request.getCustomerPhone()) >= PHONE_MIN_LENGTH)
                .filter(request -> containsPhones("380991234567", request.getCustomerPhone()))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private static boolean containsPhones(String phoneFilter, String actualPhone) {
        return (StringUtils.contains(phoneFilter, actualPhone));
    }

    private static String formatToApiDate(LocalDateTime dateFrom) {
        return dateFrom.format(API_DATE_FORMATTER);
    }

    private static RequestFilterCriteria setDefaults(RequestFilterCriteria criteria) {
        if (criteria == null) {
            criteria = new RequestFilterCriteria();
        }
        if (criteria.getDateFrom() == null) {
            criteria.setDateFrom(DEFAULT_DATE_FROM_SUPPLIER.get());
        }
        if (criteria.getDateTo() == null) {
            criteria.setDateTo(DEFAULT_DATE_TO_SUPPLIER.get());
        }
        return criteria;
    }

    private static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("dvornik-v@foxtrot.com.ua", "Qwerty_1");
        return headers;
    }
}
