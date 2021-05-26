package com.groovy.dateTime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LocalDateTimeSortMain {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.now().plusHours(1);
        LocalDateTime localDateTime2 = LocalDateTime.now().plusHours(2);

        List<LocalDateTime> list = new ArrayList<>(List.of(localDateTime, localDateTime1, localDateTime2));

        System.out.println(list);

        Collections.sort(list, new Comparator<LocalDateTime>() {
            @Override
            public int compare(LocalDateTime o1, LocalDateTime o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(list.stream().findFirst());
    }
}
