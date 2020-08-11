package com.groovy.enums;

import org.springframework.util.ReflectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {


//        System.out.println(ReflectionUtils.getAllDeclaredMethods(Sex.class));
//
//        try {
//            Method method = Sex.class.getDeclaredMethod("fromValue", String.class);
//            Object o = method.invoke(null, "Жіноча_1");
//            System.out.println(o);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Object enumStream = Arrays.stream(ReflectionUtils.getDeclaredMethods(Sex.class))
//                .filter(it -> it.getName().equals("fromValue"))
//                .map(method -> ReflectionUtils.invokeMethod(method, Sex.class, "Жіноча_1"))
//                .map(String.class::cast);
//
//
//        System.out.println(enumStream);

//        List res = findAll(Sex.class);
//        System.out.println(res);
//
//        System.out.println(getEnumFromValue(Sex.class, "Жіноча_1"));

//        BigDecimal decimal = BigDecimal.valueOf(12299);
//        BigInteger integer = BigInteger.valueOf(decimal.longValue());
//        System.out.println(integer);

        BigDecimal tes = null;

        System.out.println(tes.longValue());


    }

    public static List findAll(Class<? extends Enum> clasz) {
        return Stream.of(clasz.getEnumConstants())
                .flatMap(it -> getValue(it).stream())
                .collect(Collectors.toList());
    }

    private static Optional<String> getValue(Object object) {
        return Optional.ofNullable(ReflectionUtils.findMethod(object.getClass(), "value"))
                .map(method -> ReflectionUtils.invokeMethod(method, object))
                .map(String.class::cast);
    }

    private static Enum getEnumFromValue(Class<? extends Enum> clasz, String value){

        return Optional.ofNullable(ReflectionUtils.findMethod(clasz, "fromValue", String.class))
                .map(method -> ReflectionUtils.invokeMethod(method, clasz))
                .map(clasz::cast)
                .orElse(null);
    }



//    public static Optional<String> getValue(Object object) {
//        return Optional.ofNullable(ReflectionUtils.getDeclaredMethods(object.getClass(), "fromValue"))
//                .map(method -> ReflectionUtils.invokeMethod(method, object))
//                .map(String.class::cast);
//    }
}
