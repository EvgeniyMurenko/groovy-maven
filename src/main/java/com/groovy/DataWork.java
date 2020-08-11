package com.groovy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DataWork {

    public static void main(String[] args) {

        /*Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        System.out.println("Date " + c.getTime());*/


        LocalDate previousMonday = LocalDate.now().with( TemporalAdjusters.next( DayOfWeek.TUESDAY ) );


        System.out.println(previousMonday);
    }
}
