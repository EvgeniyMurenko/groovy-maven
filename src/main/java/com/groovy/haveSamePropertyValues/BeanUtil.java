package com.groovy.haveSamePropertyValues;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
public class BeanUtil {
    public static <T> boolean haveSamePropertyValues (T t1, T t2, PropertyDescriptor[] propertyDescriptors) throws Exception {

        for (PropertyDescriptor pd : propertyDescriptors) {
            Method m = pd.getReadMethod();
            Object o1 = m.invoke(t1);
            Object o2 = m.invoke(t2);
            if (!Objects.equals(o1, o2)) {
                return false;
            }
        }

        return true;
    }
}
