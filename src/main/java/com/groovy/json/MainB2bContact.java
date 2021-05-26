package com.groovy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groovy.json.model.B2bContactJsonDTO;

public class MainB2bContact {


    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();


        String json = "{\"item\":{\"id\":null,\"goods\":{\"id\":6363707,\"name\":\"Пылесос PHILIPS FC8293/01\",\"article\":\"\"},\"price\":0,\"services\":[],\"specialOffer\":null,\"accruedBonuses\":0,\"orderedQuantity\":1,\"confirmedQuantity\":1},\"declarer\":{\"city\":{\"id\":38046,\"name\":\"Чернигов\",\"region\":\"Черниговская\",\"district\":null,\"locationType\":{\"id\":3,\"name\":\"Город\"}},\"flat\":\"4\",\"keys\":{\"id\":10199364,\"leId\":19679588,\"typeId\":\"INDIVIDUAL\"},\"email\":\"geranastasiia@gmail.com\",\"floor\":\"3\",\"house\":\"1\",\"street\":{\"id\":38065710,\"type\":{\"id\":7,\"name\":\"Проспект\",\"nameShort\":\"просп.\"},\"value\":\"Мира\",\"district\":null},\"entrance\":\"2\",\"lastName\":\"Герасименко\",\"firstName\":\"Анастасия\",\"middleName\":\"Николаевна\",\"mobilePhone\":\"380937870735\"},\"saleSource\":\"ФТ\",\"prophylaxis\":false,\"receivedDate\":\"2021-05-14\",\"warrantyType\":2,\"insuranceCaseComments\":\"ТЕСТ - Заявленная неисправность\"}";


        try {
            B2bContactJsonDTO b2bContactJsonDTO = objectMapper.readValue(json, B2bContactJsonDTO.class);
            System.out.println(b2bContactJsonDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
