package com.groovy.json.jsonPath;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String body = "{\"items\":[{\"type\":\"sale\",\"entity\":{\"id\":6741889,\"type\":\"WEB\"}},{\"type\":\"sale\",\"entity\":{\"id\":6741889,\"type\":\"RETAIL\"}},{\"entity\":{\"id\":6741889,\"type\":\"WEB\"}},{\"type\":\"sale\",\"entity\":{\"id\":6741889}},{\"type\":\"sale\",\"entity\":{\"type\":\"WEB\"}}],\"eventType\":\"TODO\"}";

        JsonPathFilter jsonPathFilter = new JsonPathFilter();
        Task task = jsonPathFilter.createTask(body);

        jsonPathFilter.filterTask(List.of(task));
    }
}
