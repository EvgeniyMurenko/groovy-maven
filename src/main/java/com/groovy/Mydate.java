package com.groovy;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mydate {

    public static void main(String[] args) throws ParseException {

        String sourceDate = "2019-02-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = format.parse(sourceDate);
        myDate = DateUtils.addDays(myDate, 30);


        System.out.println(myDate);
    }
}
