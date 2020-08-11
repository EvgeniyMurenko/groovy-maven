package com.groovy;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

public class Sender {

    public static void main(String[] args) {

        String url = "https://vchasno.ua/api/v2/documents?is_multilateral=true";
        String authorization = "519a8828-3a66-490e-aaa9-5565255b11e9";


        FileSystemResource value = new FileSystemResource(new File("my_pdf.pdf"));

        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("file", value);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);


        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        response.getStatusCode();


        System.out.println(response);



    }

}
