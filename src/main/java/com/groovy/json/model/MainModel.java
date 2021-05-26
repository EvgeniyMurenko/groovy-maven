package com.groovy.json.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groovy.json.SmsMessageDTO;
import com.groovy.logistic.dto.DictionaryItemDTO;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.TypeRef;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainModel {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String json = "{\"item\":{\"id\":452922893,\"goods\":{\"id\":6485511,\"name\":\"LCDtv>42\\\" HISENSE 55B7700UW\",\"nameRu\":\"Телевизоры HISENSE 55B7700UW\",\"nameUa\":\"Телевізор HISENSE 55B7700UW\",\"article\":\"55B7700UW\",\"software\":false},\"price\":16999.9,\"hidden\":false,\"service\":false,\"services\":[{\"type\":{\"name\":\"Страховой продукт \\\"Мастер Сервис\\\" МП Фокстрот 2 года 1999 грн\",\"price\":1999,\"descriptions\":[{\"descriptionRu\":\"Страховой продукт \\\"Мастер Сервис\\\" МП Фокстрот\",\"descriptionUa\":\"Страховий продукт \\\"Мастер Сервiс\\\" МП Фокстрот\"}]},\"price\":1999,\"contractNumber\":\"+17500709821\"}],\"specialOffer\":{\"id\":136357,\"code\":\"Пов. бонус(14дн)_Z\",\"name\":\"Бонус за понижение кредита_Z\",\"type\":{\"id\":58,\"value\":\"Повышенные бонусы по ПЛ\"},\"active\":true,\"dateEnd\":\"2021-12-31\",\"dateStart\":\"2019-06-26\"},\"accruedBonuses\":850,\"debitedBonuses\":0,\"certificateData\":{\"result\":{\"id\":9142265,\"owner\":\"  \",\"number\":\"+17500709821\",\"typeId\":33450141,\"expDate\":\"2022-02-01T00:00:00\",\"isValid\":true,\"isActive\":true,\"sellDate\":\"2020-02-01T00:00:00\",\"isBrigadeJob\":false},\"isSucceeded\":true},\"orderedQuantity\":1},\"declarer\":{\"city\":{\"id\":38044,\"name\":\"Киев\",\"region\":\"Киевская\",\"locationType\":{\"id\":3,\"name\":\"Город\"}},\"flat\":\"95\",\"keys\":{\"id\":6383043,\"leId\":11722935,\"typeId\":\"INDIVIDUAL\"},\"email\":\"dimaxkolya@gmail.com\",\"floor\":5,\"house\":\"6\",\"street\":{\"id\":38055396,\"type\":{\"id\":6,\"value\":\"Улица\"},\"value\":\"Октяберская\",\"district\":{\"id\":38267484,\"type\":{\"id\":5,\"value\":\"Район\"},\"value\":\"Киево-Cвятошинский р-н\"}},\"entrance\":\"1\",\"lastName\":\"Крысина\",\"firstName\":\"Ирина\",\"middleName\":\"Николаевна\",\"mobilePhone\":\"380671511955\"},\"damageType\":110,\"accidentDate\":1616082944301,\"receivedDate\":\"2020-02-01T00:00:00\",\"insuranceCaseComments\":\"Обстоятельства наступления страхового случая\"}";
//        Map<String, String> map = new HashMap<>();
//        map.put("cityId", "$['declarer']['city']['id']");
//        map.put("streetId", "$['declarer']['street']['id']");
//        map.put("house", "$['declarer']['house']");
//        map.put("entrance", "$['declarer']['entrance']");
//        map.put("floor", "$['declarer']['floor']");
//        map.put("apartment", "$['declarer']['flat']");
//        map.put("customerMobilePhone", "$['declarer']['mobilePhone']");
//        map.put("lastName", "$['declarer']['lastName']");
//        map.put("firstName", "$['declarer']['firstName']");
//        map.put("middleName", "$['declarer']['middleName']");
//        map.put("customerName", "");
//        map.put("deliveryGoodsDate", "$['receivedDate']");
//        map.put("preparationDate", "$['preparationDate']");
//        map.put("insuranceCaseComments", "$['insuranceCaseComments']");
//        map.put("warrantyType", "$['warrantyType']");
//        map.put("brigadeId", "$['timeWindow']['brigadeId']");
//        map.put("implementationStartDate", "$['timeWindow']['from']");
//        map.put("implementationEndDate", "$['timeWindow']['to']");
//        map.put("goods", "$['item']['goods']['id']");
//        map.put("serviceTypeId", "$['item']['certificateData']['result']['typeId']");
//        map.put("fault", "$['insuranceCaseComments']");
//        map.put("serviceCenterId", "$['timeWindow']['serviceCenterId']");
//        map.put("sellGoodsDate", "$['receivedDate']");
//        map.put("certificateNumber", "$['item']['certificateData']['result']['number']");
//
//        Configuration jsonConfig = Configuration.builder()
//                .options(Option.DEFAULT_PATH_LEAF_TO_NULL, Option.SUPPRESS_EXCEPTIONS)
//                .build();
//        DocumentContext jsonContext = JsonPath.parse(json, jsonConfig);
//
//        TestModel testModel = new TestModel();
//        for (Field field : TestModel.class.getDeclaredFields()) {
//            String path = map.get(field.getName());
//            if (StringUtils.isNotBlank(path)) {
//                field.setAccessible(true);
//                Object value = jsonContext.read(path, field.getType());
//
//                Object result = null;
//                if (DictionaryItemDTO.class.equals(field.getType())) {
//                    DictionaryItemDTO dictionaryItemDTO = new DictionaryItemDTO();
//                    dictionaryItemDTO.setId(Long.parseLong(value.toString()));
//                    dictionaryItemDTO.setValue("value");
//                    result = dictionaryItemDTO;
//                } else if (LocalDateTime.class.equals(field.getType())) {
//                    result = LocalDateTime.parse(value.toString(), formatter);
//                } else {
//                    result = value;
//                }
//
//                try {
//                    field.set(testModel, result);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
         String messageJson = "{\"phone\": \"380937870735\", \"parameters\": [{\"name\": \"PARAM_0\", \"value\": \"test message\"}], \"templateId\": 11653}";

        SmsMessageDTO request = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            request = objectMapper.readValue(messageJson, SmsMessageDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(request);
    }

    private static  <T> T getNullSafe(DocumentContext jsonContext, String path, TypeRef<T> typeRef) {
        if (StringUtils.isBlank(path)) return null;
        try {
            return jsonContext.read(path, typeRef);
        } catch (PathNotFoundException e) {
            return null;
        }
    }
}
