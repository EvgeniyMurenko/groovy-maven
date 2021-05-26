package com.groovy.map;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainMap {

    public static void main(String[] args) {

        City city1 = new City(1L, "London");
        City city2 = new City(1L, "London");
        City city3 = new City(2L, "Milan");

        List<City> cities = List.of(city1, city2, city3);

        Map<Long, Long> alphaToBoolMap = cities.stream()
                .collect(Collectors.groupingBy(City::getId, Collectors.counting()));

        System.out.println(alphaToBoolMap);

    }

    private static boolean summingInt(Object getId) {
        return Objects.isNull(getId);
    }


    @Data
    static class City {
        private Long id;
        private String name;

        public City(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
