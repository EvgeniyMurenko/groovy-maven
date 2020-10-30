package com.groovy;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MainBigDecimal {

    public static void main(String[] args) throws IOException {

//        List<BigDecimal> list = List.of(
//          BigDecimal.ONE,
//          BigDecimal.TEN,
//          new BigDecimal(2)
//        );
//
//        BigDecimal result = list.stream()
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
////        System.out.println(result);
//
//
//        List<Integer> integerList = List.of(2, 4, 6, 8, 10);
//        long sum = integerList.stream().mapToLong(it -> (long) it)
//                .sum();
//        System.out.println(sum);
//
//        Integer val = 1;
//
//        if ("some".equals(val)){
//
//            System.out.println("!!!!!!!!!");
//        } else {
//            System.out.println("---------------");
//        }

//        JavaTimeModule module = new JavaTimeModule();
//        LocalDateTimeDeserializer localDateTimeDeserializer =  new
//                LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME);
//        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        objectMapper.registerModule(module);
//        String strDateTime = "2019-09-28T11:10:25";
//        LocalDateTime result = objectMapper.readValue(strDateTime, LocalDateTime.class);
//        System.out.println(result);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextDay = LocalDateTime.now().plusDays(1L);

        LocalDateTime result = List.of(nextDay, now)
            .stream().min(LocalDateTime::compareTo).get();

        System.out.println(result);

    }
}
