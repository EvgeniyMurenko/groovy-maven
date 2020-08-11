package com.groovy.xMLGregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws DatatypeConfigurationException {


        String str = "2000/06/14T00:00:00.000Z";
        str = getValidateDate(str);




    }


    private static String getValidateDate(String date) {
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");
        try {
            dateTimeFormatter.parse(date);
            return date;
        } catch (Exception e) {
            return date+"T00:00:00.000Z";
        }
    }
}
