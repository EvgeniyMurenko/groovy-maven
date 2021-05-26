package com.groovy.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groovy.json.model.B2bContactResult;
import com.groovy.json.model.B2bModel;
import org.springframework.core.ParameterizedTypeReference;

public class MainB2bModel {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();


        String json = "{\"isSucceeded\":true,\"errors\":[],\"result\":{\"certificateNumber\":null,\"registrationDate\":\"2021-05-17T15:51:54\",\"status\":{\"id\":10,\"name\":\"Черновик\"},\"type\":{\"id\":20,\"name\":\"Ремонт\"},\"sellGoodsDate\":null,\"deliveryGoodsDate\":\"2021-05-14T00:00:00\",\"placePreparationDate\":null,\"postponedTillDate\":null,\"questionnaire\":[],\"brigadeId\":null,\"serviceCenterId\":null,\"implementationStartDate\":null,\"implementationEndDate\":null,\"goods\":{\"id\":6363707,\"name\":\"Пылесос Vac/cl PHILIPS FC8293/01\"},\"messagesCount\":0,\"comment\":\"ТЕСТОВАЯ ЗАЯВКА С ЕО!\",\"fault\":null,\"customerName\":\"Герасименко Анастасия Николаевна\",\"customerMobilePhone\":\"0937870735\",\"customerHomePhone\":null,\"cityId\":38046,\"streetId\":38065710,\"house\":\"1\",\"entrance\":\"2\",\"floor\":\"3\",\"apartment\":\"4\",\"warrantyType\":{\"id\":2,\"name\":\"Платный\"},\"insuranceCaseDate\":\"2021-05-17T15:51:56\",\"insuranceCaseComments\":\"ТЕСТ - Заявленная неисправность\",\"isDeleted\":false,\"id\":12482016,\"guid\":null},\"message\":null}";


        try {
            B2bContactResult<B2bModel> resutl = objectMapper.readValue(json, new TypeReference<B2bContactResult<B2bModel>>() {
            });


            System.out.println(resutl);
            B2bModel result = resutl.getResult();
            result.setId(null);
            String request = objectMapper.writeValueAsString(result);
            System.out.println(request);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
