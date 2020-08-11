package com.groovy.files;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        File file = new File("/home/evgeniy/IdeaProjects/groovy-maven/src/main/resources/goods.json");
        if (file.exists()){
            System.out.println("!!!!!!!!!");
        }

        try {
            String contents = new String(Files.readAllBytes(Paths.get("/home/evgeniy/IdeaProjects/groovy-maven/src/main/resources/goods.json")));
            System.out.println(contents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
