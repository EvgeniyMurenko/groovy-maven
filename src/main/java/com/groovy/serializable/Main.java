package com.groovy.serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jol.vm.VM;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        ObjectMapper objectMapper = new ObjectMapper();

        MyObject object1 = new MyObject(1L, "val1");
        MyObject object2 = new MyObject(2L, "val2");
        MyObject object3 = new MyObject(3L, "val3");

        Map<Long, List<MyObject>> map = Map.of(1L, List.of(object1, object2, object3));

        String stringSer = toString(map);
        String stringJson = objectMapper.writeValueAsString(map);

        System.out.println(VM.current().sizeOf(stringSer));
        System.out.println(VM.current().sizeOf(stringJson));


//        Map<Long, List<MyObject>> mapFrom = (Map<Long, List<MyObject>>) fromString(string);

//        System.out.println(map);
//        System.out.println(mapFrom);

    }

    private static Object fromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    private static String toString(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
