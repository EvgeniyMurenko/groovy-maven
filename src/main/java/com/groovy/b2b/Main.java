package com.groovy.b2b;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //byte[] arr = {173,113,217,15,211,71,65,161,152,92,223,125,51,161,5,40};


        B2bContactRequestPayload payload = new B2bContactRequestPayload();
        payload.setFullName("Коваленко Наталія Володимирівна");
        payload.setStatusId(40L);
        payload.setRegisterDate(LocalDateTime.of(2019, 8, 6 ,8, 40, 42));
        payload.setApplicationActivityStatus(null);
        payload.setApplicationAuthorIds(List.of(173L,113L,217L,15L,211L,71L,65L,161L,152L,92L,223L,125L,51L,161L,5L,40L));
        payload.setHomePhone(null);
        payload.setSumRemain(null);
        payload.setTypeId(130L);
        payload.setArchived(null);
        payload.setServiceCenterId(null);


        List<B2bModel> models = new ArrayList<>();
        for (B2bPath path: B2bPath.values()) {
            B2bModel model = new B2bModel();
            model.setPath(path.name());
            model.setOp(StringUtils.lowerCase(B2bOperation.REPLACE.name()));

            switch (path){
                case FIO: model.setValue("test"); break;
                case StatusId: model.setValue(String.valueOf(40L)); break;
                case RegisterDate: model.setValue(LocalDateTime.of(2019, 8, 6 ,8, 40, 42).toString()); break;
                case RR_IS_ACTIVE: model.setValue(null); break;
                case RR_CREATOR_ID: model.setValue(List.of(173L,113L,217L,15L,211L,71L,65L,161L,152L,92L,223L,125L,51L,161L,5L,40L).toString()); break;
                case HomePhone: model.setValue(""); break;
                case SUM_REMAIN: model.setValue(null); break;
                case TypeId: model.setValue(String.valueOf(130L)); break;
                case rr_archived: model.setValue(null); break;
                case ServiceCenterId: model.setValue(null); break;
            }

            models.add(model);
        }


        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(models);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(result);

    }
}
