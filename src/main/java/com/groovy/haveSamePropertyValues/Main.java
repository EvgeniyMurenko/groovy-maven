package com.groovy.haveSamePropertyValues;

import java.beans.BeanInfo;
import java.beans.Introspector;

public class Main {

    public static void main(String[] args) throws Exception {

        Model m1 = new Model(1L, "Value1", "other string", Boolean.TRUE, 1L);
        Model m3 = new Model(1L, "Value1", "other string", Boolean.TRUE, 1L);
        Model m2 = new Model(2L, "Value2", "other string", Boolean.TRUE, 2L);

        BeanInfo beanInfo = Introspector.getBeanInfo(Model.class);
        Boolean b = BeanUtil.haveSamePropertyValues(m1, m2, beanInfo.getPropertyDescriptors());
        System.out.println(b);

    }
}
