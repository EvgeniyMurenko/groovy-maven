package com.groovy.json.jsonPath;

import com.jayway.jsonpath.JsonPath;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class JsonPathFilter {

    private final String filter = "$.items[?(@.type=='sale' && (@.entity.type=='WEB' || @.entity.type=='RETAIL') && (@.entity.id!=null))]";

    public Task createTask(String boby){
        Task task = new Task();
        task.setBody(boby);
        return task;
    }

    public void filterTask(List<Task> tasks){

        List<Object> collect = tasks.stream()
                .map(it -> JsonPath.parse(it.getBody()))
                .map(it -> it.read(filter))
                .collect(Collectors.toList());

        System.out.println(collect);

    }

    private Sale toSale(Object o) {
        return (Sale) o;
    }
}

@Data
class Task {
    private String body;
}

@Data
class Sale {
    private Long id;
    private String type;
}

@Data
class Collect {
    List<Item> items;
}

@Data
class Item {
    private String type;
    private Entity entity;
}

@Data
class Entity {
    private Long id;
    private String type;
}

