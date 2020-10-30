package com.groovy.logistic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groovy.logistic.dto.AvailableSaleDeliveryDTO;
import com.groovy.logistic.dto.CityData;
import com.groovy.logistic.dto.DeliveryInfoRequestDTO;
import com.groovy.logistic.dto.GoodsData;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Logistic {

    private static final String INTEGRATION_URL = "http://localhost:8080/integration-api/api/deliveries";
    private static final String REACTIVE_URL = "http://localhost:8081/integration-api-reactive/api/deliveries/calculate";

    private ObjectMapper objectMapper;

    public Logistic() {
        this.objectMapper = new ObjectMapper();
    }

    public void start() {

        DeliveryInfoRequestDTO body = createBody();

//        List<AvailableSaleDeliveryDTO> t22Result = sendTo(INTEGRATION_URL, body);
        List<AvailableSaleDeliveryDTO> result = sendTo(REACTIVE_URL, body);


//        try {
//            writeResultToFile(body, t22Result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void writeResultToFile(DeliveryInfoRequestDTO body, List<AvailableSaleDeliveryDTO> t22Result) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Result");

        String[] columns = {"Request", "t22Result", "logisticResult"};

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            HSSFCell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(columns[i]);
        }

        HSSFRow row = sheet.createRow(1);
        row.createCell(0).setCellValue(toString(body));
        row.createCell(1).setCellValue(toString(t22Result));
        row.createCell(2).setCellValue(Objects.isNull(t22Result) ? 0 : t22Result.size());

        FileOutputStream fileOut = new FileOutputStream("result.xlsx");

        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    private List<AvailableSaleDeliveryDTO> sendTo(String url, DeliveryInfoRequestDTO body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> exchange;
        try {
            exchange = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(toString(body), headers), String.class);
        } catch (HttpStatusCodeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return toList(exchange.getBody(), AvailableSaleDeliveryDTO.class);
    }

    private DeliveryInfoRequestDTO createBody() {
        DeliveryInfoRequestDTO dto = new DeliveryInfoRequestDTO();
        dto.setStrategy(ProcessingStrategy.T22);
        dto.setCityId(CityData.getId());
//        dto.setSaleDetails(createListDetails());
        dto.setSaleDetails(List.of());
        return dto;
    }

    private List<SaleDetailDTO> createListDetails() {
        int maxItem = (int) (1 + Math.random() * 3);
        List<SaleDetailDTO> result = new ArrayList<>();
        for (int i = 0; i < maxItem; i++) {
            SaleDetailDTO detailDTO = createDetail();
            result.add(detailDTO);
        }
        return result;
    }

    private SaleDetailDTO createDetail() {
        SaleDetailDTO dto = new SaleDetailDTO();
        dto.setGoodId(GoodsData.getId());
        dto.setOrderedQuantity(BigDecimal.valueOf((int) (1 + Math.random() * 3)));
        dto.setPriceSite(BigDecimal.valueOf(Math.random() * 10000));
        return dto;
    }

    private String toString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<AvailableSaleDeliveryDTO> toList(String jsonString, Class<AvailableSaleDeliveryDTO> tClass) {
        List<AvailableSaleDeliveryDTO> result = new ArrayList<>();
        try {
            result = objectMapper.readValue(jsonString, new TypeReference<List<AvailableSaleDeliveryDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(jsonString);
        }
        return result;
    }
}
