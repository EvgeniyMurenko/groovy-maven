package com.groovy.json.locatDateTime.model;

import com.groovy.error.InternalServerErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;


public class RestService {

    public B2bContactRequestMessage getResult() {
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080/")
                .path("/tool-api/api/calculate")
                .build().toUri();

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<B2bContactResult<B2bContactRequestMessage>> exchange;
        try {
            exchange = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
                    new ParameterizedTypeReference<B2bContactResult<B2bContactRequestMessage>>() {
                    });
            B2bContactResult<B2bContactRequestMessage> response = exchange.getBody();
            if (Objects.nonNull(response) && Objects.nonNull(response.getResult())) {
                return response.getResult();
            }
            throw new InternalServerErrorException("Failed to get response result B2bContactRequestMessage");
        } catch (HttpStatusCodeException e) {
            String msg = String.format("Failed to save b2b message. Response status: %s, body: %s", e.getStatusCode().toString(), e.getResponseBodyAsString());
            throw new InternalServerErrorException(msg);
        }
    }
}
