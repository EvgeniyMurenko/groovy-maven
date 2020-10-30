package com.groovy.novaPochta.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    private final DateTimeFormatter formatter;

    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
        this.formatter = DateTimeFormatter.ofPattern(PATTERN);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return LocalDateTime.parse(parser.getText(), formatter);
    }
}
