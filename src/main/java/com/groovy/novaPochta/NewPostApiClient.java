package com.groovy.novaPochta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.groovy.novaPochta.model.NewPostApiRequest;
import com.groovy.novaPochta.model.NewPostApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class NewPostApiClient {

    private static final String API_KEY = "2be29c20bbe8970f4b4dc01f756bcb55";
    //    private static final String API_KEY = "http://testapi.novaposhta.ua/v2.0/en/json/getDocumentDeliveryDate/";
    private static final String URL = "https://api.novaposhta.ua/v2.0/json";
    private static final String GET_DELIVERY_DATE_PATH = "/getDocumentDeliveryDate";
    private static final DateTimeFormatter API_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final ObjectMapper objectMapper;

    public NewPostApiClient() {
        this.objectMapper = new ObjectMapper();
    }


    public void getDocumentDeliveryDate() {

        NewPostApiRequest model = new NewPostApiRequest("InternetDocument", "getDocumentDeliveryDate",
                LocalDateTime.now(), "WarehouseDoors", "8d5a980d-391c-11dd-90d9-001a92567626",
                "8d5a980d-391c-11dd-90d9-001a92567626");

        sendTo(model, GET_DELIVERY_DATE_PATH);
    }

    private void sendTo(NewPostApiRequest body, String path){
        body.setApiKey(API_KEY);

//        URI url = UriComponentsBuilder.fromUriString(URL)
//                .path(path)
//                .build().toUri();

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        ResponseEntity<ResponseModel> exchange = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(toJson(body), headers), ResponseModel.class);
//        ResponseModel result = exchange.getBody();
//
//        if (Objects.isNull(result) || !result.getSuccess()){
//            log.error("Errors = {}", result.getErrors());
//        }
//
//
//        LocalDateTime dateTime = result.getDataObjects().stream()
//                .findFirst().map(it -> it.getDeliveryDate().getDate()).get();
//
//        Integer between = Period.between(LocalDate.now(), dateTime.toLocalDate()).getDays();


        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer ->
                        configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper)))
                .build();

        URI url = UriComponentsBuilder.fromUriString(URL)
                .path(path)
                .build().toUri();

        NewPostApiResponse result = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .build()
                .post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(NewPostApiResponse.class)
                .block();

        System.out.println(result);
    }


    private String toJson(Object content) {
        try {
            return objectMapper.writeValueAsString(content);
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize content {} to JSON", content, e);
            throw new IllegalStateException("Failed to serialize content to JSON. Exception: " + e.getMessage());
        }
    }

    private <T> T fromJsonToObject(String json, Class<T> tClass){
        try {
            return objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize JSON to object: " + tClass.getSimpleName() + ", JSON: " + json, e);
        }
    }
}
