package com.groovy.json;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidateJson {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");


    public static void main(String[] args) {
//        JsonSchema schema = factory.getJsonSchema(fstabSchema);
//
//        JSONObject jsonSchema = new JSONObject(new JSONTokener(ValidateJson.class.getResourceAsStream("schema.json")));
//        JSONObject jsonSubject = new JSONObject(new JSONTokener(ValidateJson.class.getResourceAsStream("product_invalid.json")));
//
//        Schema schema = SchemaLoader.load(jsonSchema);
//        schema.validate(jsonSubject);




        String one = StringUtils.deleteWhitespace("Побутова техніка|кондиціонери(спліт-системи)");

        String two = StringUtils.deleteWhitespace("Побутова техніка|кондиціонери (спліт-системи)");

        System.out.println(one);
        System.out.println(two);

        System.out.println(StringUtils.trimToEmpty(one).equals(StringUtils.trimToEmpty(two)));
    }


    public static boolean isValidate(String date) {

        try {
            dateTimeFormatter.parse(date);
            return true;
        } catch (Exception e) {
        }

        return false;
    }


}
