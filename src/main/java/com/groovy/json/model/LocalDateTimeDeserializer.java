package com.groovy.json.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private final DateTimeFormatter ISO_DATE = DateTimeFormatter.ISO_DATE;
    private final DateTimeFormatter ISO_DATE_TIME = DateTimeFormatter.ISO_DATE_TIME;

    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        try {
            return LocalDateTime.parse(parser.getText(), ISO_DATE_TIME);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return LocalDate.parse(parser.getText(), ISO_DATE).atStartOfDay();
    }
}
