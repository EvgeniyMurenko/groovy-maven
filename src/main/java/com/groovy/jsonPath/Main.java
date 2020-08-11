package com.groovy.jsonPath;

import com.groovy.b2b.B2bModel;
import com.groovy.b2b.B2bOperation;
import com.groovy.b2b.B2bPath;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


       /* String jsonDataSourceString = "{\"item\": {\"id\": 201961344, \"goods\": {\"id\": 5722219, \"name\": \"BreadM/breadmaker GORENJE BM 900 AL (BM1309)\", \"nameRu\": \"Хлебопечка GORENJE BM 900 AL\", \"nameUa\": \"Хлібопіч GORENJE BM 900 AL\", \"article\": \"284333\"}, \"price\": 999, \"service\": null, \"services\": null, \"priceSite\": null, \"promoCode\": null, \"receiveDate\": null, \"specialOffer\": null, \"accruedBonuses\": 0, \"debitedBonuses\": 0, \"deliveryStatus\": null, \"orderedQuantity\": 1, \"confirmedQuantity\": null}, \"type\": \"Не гарантийный\", \"declarer\": {\"city\": {\"id\": 38044, \"value\": \"Киев\"}, \"email\": \"hhhhhh@mmmm.com\", \"floor\": null, \"street\": {\"id\": 38511143, \"value\": \"Оноре де Бальзака\"}, \"houseNo\": null, \"entrance\": null, \"lastName\": \"Скрипка\", \"apartment\": null, \"firstName\": \"Лидия\", \"middleName\": \"Васильевна\", \"phoneNumber\": null}, \"timeWindow\": \"9:00 — 21:00\", \"masterVisit\": \"2020-01-31T22:00:00.000Z\", \"malfunctionDescription\": \"неисправность\"}";



        List<B2bModel> result = createContactRequest(jsonDataSourceString);
        System.out.println(result);*/

//        for (B2bPath path: B2bPath.values()) {
//
//            if (path.equals(B2bPath.FIO)) continue;
//            System.out.println(path.name());
//        }

        System.out.println(Instant.now().toString());


    }

    private static List<B2bModel> createContactRequest(String json){
        DocumentContext jsonContext = JsonPath.parse(json);
        String fio = jsonContext.read("$['declarer']['lastName']") + " " + jsonContext.read("$['declarer']['firstName']") + " " + jsonContext.read("$['declarer']['middleName']");


        List<B2bModel> models = new ArrayList<>();
        for (B2bPath path: B2bPath.values()) {
            B2bModel model = new B2bModel();
            model.setPath(path.name());
            model.setOp(StringUtils.lowerCase(B2bOperation.REPLACE.name()));

            switch (path){
                case FIO: model.setValue(fio); break;
                case StatusId: model.setValue(20); break;
                case RegisterDate: model.setValue(LocalDateTime.now()); break;
                case RR_CREATOR_ID: model.setValue(List.of(173,113,217,15,211,71,65,161,152,92,223,125,51,161,5,40)); break;
                case HomePhone: model.setValue(jsonContext.read("$['declarer']['phoneNumber']")); break;
                case TypeId: model.setValue(20); break;
                case ServiceCenterId: model.setValue(22); break;
                case ModifierId: model.setValue(List.of(173,113,217,15,211,71,65,161,152,92,223,125,51,161,5,40)); break;
                case Comment: model.setValue("Тестовая заявка**"); break;
                case RR_FAULT: model.setValue(jsonContext.read("$['malfunctionDescription']")); break;
                case RR_VISIT_RAPAIR: model.setValue(1); break;
                case GoodsId: model.setValue(jsonContext.read("$['item']['goods']['id']")); break;
                default: model.setValue(null);
            }

            models.add(model);
        }

        return models;
    }
}
