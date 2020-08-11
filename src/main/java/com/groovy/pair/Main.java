package com.groovy.pair;

import org.springframework.data.util.Pair;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> list = List.of("1:WEB", "2:RETAIL", "3:BLABLABLA", "aaa&bbb");


        List<Pair<Long, SaleType>> pairs = list.stream()
            .map(Main::getPair)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());


        System.out.println(pairs);
    }

    private static Pair<Long, SaleType> getPair(String from) {

        try {
            String[] data = from.split(":");
            return Pair.of(Long.parseLong(data[0]), SaleType.valueOf(data[1]));
        } catch (Exception e) {
            System.out.println( "error = " + e.getMessage());

            System.exit(0);

        }

        return null;
    }
}
