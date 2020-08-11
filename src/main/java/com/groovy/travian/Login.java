package com.groovy.travian;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.*;

@Slf4j
public class Login {

    private static final String HOST = "http://x20.travimini.ru";
    private static final String LOGIN_PATH = "/login.php";
    private static final String DORF_OUT_PATH = "/dorf1.php";
    private static final String DORF_IN_PATH = "/dorf2.php";
    private static final String BUILD_PATH = "/build.php";

    private static Set<String> cookies = new HashSet<>();

    public static void main(String[] args) {


        login();

        String html = sendGet(DORF_OUT_PATH, "", false);
        Document doc = Jsoup.parse(html);


        System.out.println(doc);
        for (Element element : doc.select("table").attr("id", "vlist").select("tbody").select("a[href]")) {
            if (StringUtils.isBlank(element.text())) continue;

            String name = element.text();
            String link = element.attr("href");



            String htmlVillage = sendGet(DORF_OUT_PATH, link, false);
            String fieldVillage = sendGet(BUILD_PATH,"?id=1", false);
            Document docField = Jsoup.parse(fieldVillage);

            String vLink = "";
            for (Element element1 : docField.select("a").attr("class", "build")) {
                if (StringUtils.isBlank(element1.text()) || !element1.text().contains("Upgrade")) continue;
                String text = element1.text();
                vLink = element1.attr("href");
            }

            String timeStr = "";
            for (Element element1 : docField.select("p").attr("id", "contract")) {
                if (StringUtils.isBlank(element1.text()) || !element1.text().contains("Upgrade")) continue;
                timeStr = element1.text();
            }

            if (StringUtils.isBlank(timeStr)){
                System.out.println("Error time!");
            }
            String[] timeSplits = timeStr.trim().split("\\|");
            if (timeSplits.length != 7) {
                System.out.println("Error timeSplits!");
            }


            LocalTime localTime = LocalTime.parse( "0" + timeSplits[5].trim() );
            Long time = localTime.getLong(ChronoField.NANO_OF_DAY) / 1000000;

            String[] linkSplits = vLink.split("\\?");
            if (linkSplits.length != 2) {
                System.out.println("!!!!!!!!!!!!");
                System.exit(0);
            }
        }
    }

   // http://x69.travimini.ru/dorf2.php?a=35&c=tJX

    private static String sendGet(String path, String query, boolean referer) {
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromUriString(HOST)
            .path(path)
            .query(query.replaceAll("\\?", ""))
            .build().toUri();
        log.info(url.toString());
        System.out.println("===========>>" + url.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", String.join("; ", cookies));
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (referer){
            headers.set("Referer", HOST + path);
        }
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RestClientException("Status code not 2xx!");
        }
        return response.getBody();
    }

    private static void login() {
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromUriString(HOST)
            .path(LOGIN_PATH)
            .build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String payloadString = String.format("ft=a4&user=%s&pw=%s&s1=login", "mr_jeka", "123452");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(payloadString, headers), String.class);

        List<String> cookieList = response.getHeaders().get("Set-Cookie");
        for (String cookie : cookieList) {
            String[] splits = cookie.split(";");
            if (splits.length == 0) continue;
            cookies.add(splits[0]);
        }
    }
}
