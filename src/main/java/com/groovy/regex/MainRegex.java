package com.groovy.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegex {

    public static void main(String[] args) {


        String phoneNumber = "380445401757";

//        Pattern p = Pattern.compile("^\\+{0,1}\\d{0,2}(067|068|096|097|098|050|066|095|099|063|073|093|039|091|092|094)\\d{7}$");
//        Matcher m = p.matcher(inputstring);
//        if (m.find()) {
//            System.out.println("MOBILE");
//        } else {
//            System.out.println("Other");
//        }


        String res = "";
        if (phoneNumber.length() < 12) {
            phoneNumber = normalizePhoneNumber(phoneNumber);
        }
        res = phoneNumber.substring(1, 12);
        System.out.println(res);
    }


    public static String normalizePhoneNumber(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber) || phoneNumber.length() < 9) {
            return phoneNumber;
        }
        switch (phoneNumber.length()) {
            case 9:
                return "380" + phoneNumber;
            case 10:
                return "38" + phoneNumber;
            case 11:
                return "3" + phoneNumber;
            default:
                return phoneNumber;
        }
    }
}
