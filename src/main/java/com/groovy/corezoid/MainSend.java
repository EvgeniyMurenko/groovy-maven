package com.groovy.corezoid;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;

@Slf4j
public class MainSend {


    public static void main(String[] args) {

        String API_LOGIN = "116699";
        String API_SECRET = "96LSKg9S3FyRafl09I149sUKn0v1gkWKK07M1L4AolrrwLrdT1";
        String HOST = "https://sync-api.corezoid.com/api/1/json/";

        Long unixTime = 1616083058L;
        System.out.println("unixTime  = " + unixTime);
        String body = "{\"timeout\":30,\"ops\":[{\"conv_id\":912433,\"type\":\"create\",\"obj\":\"task\",\"data\":{\"action\":\"get_all\"}}]}";

        String SIGNATURE = Hex.encodeHexString(DigestUtils.sha1(String.format("%s%s%s%s", unixTime, API_SECRET, body, API_SECRET)));


        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromUriString(HOST)
                .path(API_LOGIN)
                .path("/")
                .path(unixTime.toString())
                .path("/")
                .path(SIGNATURE)
                .build().toUri();


        log.info(url.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Content-type", "application/json; charset=utf8");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, headers), String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RestClientException("Status code not 2xx!");
        }

        String json = response.getBody();
        System.out.println(json);



    }
}
