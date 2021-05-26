package com.groovy.serializable;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import com.esotericsoftware.kryo.kryo5.serializers.MapSerializer;
import com.google.common.collect.ImmutableList;
import lombok.ToString;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelloKryo {
    static public void main (String[] args) {
        Kryo kryo = new Kryo();
        kryo.register(Bar.class);
        kryo.register(List.class);
        kryo.register(ArrayList.class);


        Bar bar = new Bar();
        bar.field1 = "foo";
        bar.field2 = "bar";
        Map<Long, List<Bar>> map = Map.of(1L, List.of(bar));

        // write
        Output output = new Output();
        kryo.writeClassAndObject(output, List.of(bar));

        output.getBuffer();



        // read
        Input input = new Input(output.getBuffer());
        List<Bar> foo2 = (List<Bar>) kryo.readObject(input, List.class);
        System.out.println(map);
        System.out.println(foo2);
    }


    @ToString
    static public class Bar {
        public String field1;
        public String field2;
    }
}
