package com.groovy.foxtrot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.groovy.goods.Authorization;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;


public class MainRest {

    private static final String HOST = "https://foxcc.foxtrot.ua";

    public static void main(String[] args) throws IOException {

        Map<String, String> payloadAuth = Maps.newHashMap();
        payloadAuth.put("grant_type", "password");
        payloadAuth.put("password", "admin");
        payloadAuth.put("username", "admin");

        Authorization authorization = fromString(post("auth/login", payloadAuth), Authorization.class);
        if (authorization == null) return;


        get("/services/uaa/api/users/online", authorization.getAccessToken());

    }

    private static <T> T fromString(String json, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String get(String path, String key) {
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromUriString(HOST)
            .path(path)
            .build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        if (StringUtils.isNotBlank(key)){
            headers.set("Authorization", String.format("Bearer %s", key));
        }
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RestClientException("Status code not 2xx!");
        }
        return response.getBody();
    }

    private static String post(String path, Map payload) {
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromUriString(HOST)
            .path(path)
            .build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(toJson(payload), headers), String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RestClientException("Status code not 2xx!");
        }
        return response.getBody();
    }

    private static String toJson(Object content) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(content);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to serialize content to JSON. Exception: " + e.getMessage());
        }
    }
}
