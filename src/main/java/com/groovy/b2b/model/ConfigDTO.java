package com.groovy.b2b.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigDTO {

    private static final List<String> DEFAULT_ENTITY = List.of("declarer.lastName", "declarer.firstName", "declarer.middleName", "declarer.mobilePhone", "declarer.city.id", "declarer.street.id", "declarer.house", "declarer.entrance", "declarer.floor", "declarer.flat");

    private String key;
    private List<String> columns;
    private List<String> entityData;

    public static ConfigDTO getDefault(String key) {
        return new ConfigDTO(key, List.of("type", "status", "note"), new ArrayList<>(DEFAULT_ENTITY));
    }

    public static ConfigDTO getInsurance(String key) {
        ConfigDTO result = getDefault(key);
        List<String> entityData = result.entityData;
        entityData.add("insuranceCaseDate");
        entityData.add("insuranceCaseComments");
        return result;
    }
}
