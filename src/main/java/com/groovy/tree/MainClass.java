package com.groovy.tree;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {


        String json = "[{\"id\":5728,\"name\":\"Сервіс \\\"FoxMaster\\\" - налаштування ПК Maximum  (на виїзді)\",\"price\":2399.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка на Выезде\",\"typeName\":\"Настройка ПК\"},{\"id\":5729,\"name\":\"Сервіс \\\"FoxMaster\\\" - налаштування ПК Minimum  (на виїзді)\",\"price\":999.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка на Выезде\",\"typeName\":\"Настройка ПК\"},{\"id\":5730,\"name\":\"Сервіс \\\"FoxMaster\\\" - налаштування ПК Standard  (на виїзді)\",\"price\":1199.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка на Выезде\",\"typeName\":\"Настройка ПК\"},{\"id\":5711,\"name\":\"Сервіс \\\"FoxMaster\\\" - налаштування ПК Ultra\",\"price\":2999.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка в Магазине\",\"typeName\":\"Настройка ПК\"},{\"id\":5731,\"name\":\"Сервіс \\\"FoxMaster\\\" - налаштування ПК Ultra  (на виїзді)\",\"price\":2999.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка на Выезде\",\"typeName\":\"Настройка ПК\"},{\"id\":5720,\"name\":\"Сервіс \\\"FoxMaster\\\" - онлайн підтримка Maximum\",\"price\":799.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- Он-Лайн Поддержка \",\"typeName\":\"ПК\"},{\"id\":5721,\"name\":\"Сервіс \\\"FoxMaster\\\" - онлайн підтримка Minimum\",\"price\":349.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- Он-Лайн Поддержка \",\"typeName\":\"ПК\"},{\"id\":5722,\"name\":\"Сервіс \\\"FoxMaster\\\" - онлайн підтримка Standard\",\"price\":499.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- Он-Лайн Поддержка \",\"typeName\":\"ПК\"},{\"id\":4176,\"name\":\"Сервіс \\\"FoxMaster\\\" налаштування ПК Maximum\",\"price\":2399.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка в Магазине\",\"typeName\":\"Настройка ПК\"},{\"id\":4177,\"name\":\"Сервіс \\\"FoxMaster\\\" налаштування ПК Minimum\",\"price\":999.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка в Магазине\",\"typeName\":\"Настройка ПК\"},{\"id\":4178,\"name\":\"Сервіс \\\"FoxMaster\\\" налаштування ПК Standard\",\"price\":1699.0,\"priority\":0,\"parentTypeName\":\"FoxMaster- настройка в Магазине\",\"typeName\":\"Настройка ПК\"},{\"id\":8148,\"name\":\"Страховий платiж \\\"МастерСервiс\\\" АМ 2 роки\",\"price\":899.0,\"priority\":0,\"parentTypeName\":\"МастерСервис\",\"typeName\":\"2 года\"},{\"id\":8160,\"name\":\"Страховий платiж \\\"МастерСервiс\\\" АМ 3 роки\",\"price\":999.0,\"priority\":0,\"parentTypeName\":\"МастерСервис\",\"typeName\":\"3 года\"},{\"id\":8865,\"name\":\"Страховий платiж \\\"МастерСервiс\\\" МП 2 роки\",\"price\":899.0,\"priority\":0,\"parentTypeName\":\"МастерСервис\",\"typeName\":\"2 года\"},{\"id\":8875,\"name\":\"Страховий платiж \\\"МастерСервiс\\\" МП 3 роки\",\"price\":999.0,\"priority\":0,\"parentTypeName\":\"МастерСервис\",\"typeName\":\"3 года\"}]";

        List<ServiceType> list = getListServ(json);


        assert list != null;

        Map<String, List<ServiceType>> map = list.stream()
            .collect(
                Collectors.groupingBy(
                    ServiceType::getParentTypeName, Collectors.mapping(
                        it-> it, Collectors.toList())
                )
            );



        Map<String, Map<String, List<ServiceType>>> personsByCountryAndCity = list.stream().collect(
            Collectors.groupingBy(ServiceType::getParentTypeName,
                Collectors.groupingBy(ServiceType::getTypeName)
            )
        );

        System.out.println(map);
/*        Map<String, List<Map<String, ServiceType>>> res  = list.stream()
            .collect(
              Collectors.groupingBy(ServiceType::getParentTypeName, Collectors.toList(
                  Collectors.groupingBy(ServiceType::getTypeName, Collectors.toList())
              ))
            );*/

    }



    private static List<ServiceType> getListServ(String json){
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            return Arrays.asList(objectMapper.readValue(json, ServiceType[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
