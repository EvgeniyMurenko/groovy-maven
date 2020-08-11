package com.groovy.valid;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobilePhone {

    private static final List<String> mobilePhone =
        List.of(
            "+380445401757",
            "380335401757",
            "80445401757",
            "0445401757",
            "+380937870735",
            "380937870735",
            "80937870735",
            "0937870735"
        );

    public static void main(String[] args) {
        for (String str: mobilePhone){
            checkPhoneIsMobile(str);
        }
    }


    private static void checkPhoneIsMobile(String mobilePhone) {
        if (StringUtils.isBlank(mobilePhone)) throw new IllegalArgumentException("Phone is empty or null");

        Pattern pattern = Pattern.compile("^\\+{0,1}\\d{0,2}(067|068|096|097|098|050|066|095|099|063|073|093|039|091|092|094)\\d{7}$");
        Matcher matcher = pattern.matcher(mobilePhone);
        if (matcher.matches()){
            System.out.println("Phone: " + mobilePhone+" is valid");
        } else {
            System.out.println("Phone: " + mobilePhone+" is not valid");
        }
    }

}
