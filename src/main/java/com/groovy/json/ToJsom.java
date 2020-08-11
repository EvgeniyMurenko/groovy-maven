package com.groovy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ToJsom {

//    {
//        "items":[{"type":"contact","entity":{"id":contact.getCode(), "entityRefId": contactEntity.getEntityRefId()}}],
//        "eventType":"taskObserve.creditBroker", "eventTypeName":"Опрос системы кредитный брокер", "taskComment": ""
//    }

    private static final String TASK_OBSERVE = "taskObserve";
    private static final String CREDIT_BROKER = "creditBroker";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> payload = new HashedMap();
        Map<String, Object> item = new HashedMap();
        Map<String, Object> entity = new HashedMap();
        entity.put("id", "contact.getCode()");
        entity.put("entityRefId", "contactEntity.getEntityRefId()");
        item.put("type", "contact");
        item.put("entity", entity);
        payload.put("items", List.of(item));
        payload.put("eventType", TASK_OBSERVE + "." + CREDIT_BROKER);
        payload.put("eventTypeName", "Опрос системы кредитный брокер");


        try {
            String res = objectMapper.writeValueAsString(payload);
            System.out.println(res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
