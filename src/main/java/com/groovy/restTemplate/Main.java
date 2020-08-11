package com.groovy.restTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {

    private static final String URL = "https://b2b-webapi-test.nash-service.com.ua/Integration/GetRepairRequests?dateFrom=202цйу0.01.01&dateTo=2020.01.23&fullresponse=true";
    private static final String username = "Dvornik-V@foxtrot.com.ua";
    private static final String password = "Qwerty_1";


    public static void main(String[] args) throws Exception {


        LocalDateTime dateFrom = LocalDateTime.of(2019, 11, 1, 0, 0, 0);
        LocalDateTime dateTo = LocalDateTime.of(2020, 1, 21, 0, 0, 0);


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = createHeaders();

        ResponseEntity<String> exchange;

        try {
            exchange = restTemplate.exchange(URL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        }catch (HttpStatusCodeException e){
            String msg = String.format("Failed to get requests by dateFrom = %s dateTo =%s. Response status: %s, body: %s", "123", "456",
                    e.getStatusCode().toString(), e.getMessage());
            System.out.println(msg);

            throw new Exception();
        }

        List<ResponseModel.ContactRequest> result = new ArrayList<>();

        Optional<ResponseModel> optional = fromJson(exchange.getBody(), ResponseModel.class);

//        if (optional.isEmpty()) System.out.println("EMPTY!!!!!!!!!!");

        ResponseModel responseModel = optional.get();

        result = responseModel.getResult().stream()
            .filter(contactRequest -> contactRequest.getCustomerPhone().length() > 6)
            .filter(contactRequest -> "380966705817".contains(contactRequest.getCustomerPhone()))
            .collect(Collectors.toList());

        System.out.println(result.size());



    }

    private static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        return headers;
    }

    private static <T> Optional<T> fromJson(String json, Class<T> resultType) {
        ObjectMapper objectMapper = new ObjectMapper();
        final String normalyzedJson = StringUtils.trimToEmpty(json).replaceAll("\\r\\n|\\r|\\n", StringUtils.EMPTY);
        try {
            if (StringUtils.isBlank(normalyzedJson)) {
                return Optional.empty();
            }
            return Optional.ofNullable(objectMapper.readValue(normalyzedJson, resultType));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize JSON to object: " + resultType.getSimpleName() + ", JSON: " + normalyzedJson, e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(resultType + " result = " + normalyzedJson);
        }

        return Optional.empty();
    }
}
