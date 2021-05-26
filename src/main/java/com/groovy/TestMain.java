package com.groovy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class TestMain {

    public static void main(String[] args) {

//        String group = "46,5101,4696,5103,6752,3123,3516,3117,2862,3510,4049,5415,6748,4769,1658,4861,3803,2679,2951,3523,1784,2871,5623,4733,6759,807,5122,7028,6730,2331,3263,4192,1719,5435,4028,1716,4547,3618,6529,3078,2061,2810,5928,542,2773,3465,5005,5568,5888,1727,5889,3507,5605";
//        Set<Long> roles = Set.of(7024L, 7027L, 7028L);


//        System.out.println(System.getProperty("baseUrl"));


//        if (Arrays.stream(group.split(","))
//                .map(Long::parseLong)
//                .anyMatch(roles::contains)) {
//            System.out.println("+++++");
//        } else {
//            System.out.println("-----");
//        }


        List<Integer> roles = List.of(1, 2, 3);
        List<Integer> other = List.of(1, 2, 4);


        List<Integer> res = Stream.concat(roles.stream(), other.stream()).distinct().collect(Collectors.toList());

        System.out.println(res);

    }
}
