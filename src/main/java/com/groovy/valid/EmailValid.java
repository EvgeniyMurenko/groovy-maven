package com.groovy.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValid {

    public static void main(String[] args) {

        String pattern = "([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,15})";

        String email = "z.murenko@gmail.codfgdfgdfgm";

//        String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        System.out.println(m.matches());


    }
}
