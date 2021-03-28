package com.senlainc.injection.utility;

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

    public Constructor<?> injection(Field field){
        return null;
    }
}
