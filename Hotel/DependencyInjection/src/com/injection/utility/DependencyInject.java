package com.injection.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class DependencyInject {
private static DependencyInject instance;

    public static DependencyInject getInstance(){
        if(instance==null){
            instance=new DependencyInject();
        }
        return instance;
    }

    public Constructor<?> injection(Field field) throws NoSuchMethodException {
        return field.getType().getDeclaredConstructor();
    }
}
