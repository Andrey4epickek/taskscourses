package com.senlainc.injection.utility;

import com.senlainc.injection.annotation.DependencyClass;
import com.senlainc.injection.annotation.DependencyComponent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DependencyService {
    private static DependencyService instance;
    private final Map<String,Object> instanceClassMap;
    private Object instanceClass;

    public DependencyService() {
        this.instanceClassMap = new HashMap<>();
    }
    public static DependencyService getInstance(){
        if(instance==null){
            instance=new DependencyService();
        }
        return instance;
    }

    public void setVariable(Class<?> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if(clazz.getAnnotation(DependencyClass.class)==null){
            throw new IllegalArgumentException("Class: "+clazz.getSimpleName()+" didn't have 'DependecyClass' annotation");
        }
        final Constructor<?> constructor=clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        this.instanceClass=constructor.newInstance();
        constructor.setAccessible(false);
        instanceClassMap.put(clazz.getName(),instanceClass);
    }

    public void initializeConstructor() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        final List<Field>
                annotatedFields= Arrays.stream(instanceClass.getClass().getDeclaredFields())
                .filter(i->!i.getType().isPrimitive()&&i.isAnnotationPresent(DependencyComponent.class))
                .collect(Collectors.toList());
        for(Field field:annotatedFields){
            final Constructor<?> constructor=DependencyInject.getInstance().injection(field);
            if(constructor.getDeclaringClass().isAnnotationPresent(DependencyClass.class)&&!instanceClassMap.containsKey(constructor.getName())){
                final Object bufInstanceClass=this.instanceClass;
                setVariable(constructor.getDeclaringClass());
                initializeConstructor();
                this.instanceClass=bufInstanceClass;
            }
            field.setAccessible(true);
            if(instanceClassMap.containsKey(constructor.getName())){
                field.set(instanceClass,instanceClassMap.get(constructor.getName()));
                field.setAccessible(false);
                continue;
            }
        }
    }

    public Object getInstanceClass(Class<?> clazz) {
        return instanceClass;
    }
}
