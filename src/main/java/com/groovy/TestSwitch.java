package com.groovy;

public class TestSwitch {

    public static void main(String[] args) {

        int res = startTest();
        System.out.println(res);
    }

    private static int startTest() {
        int val = 1;
        switch (val){
            case 1:  System.out.println(1);
                return val;
            case 2:  System.out.println(2);
                return val;
            default: return -1;
        }

    }
}
