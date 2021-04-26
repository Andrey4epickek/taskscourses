package com.hotel.configuration;

import com.hotel.configuration.annotation.ConfigClass;
import com.hotel.configuration.annotation.ConfigProperty;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConfigService {
    private static ConfigService instance;
    private Class<?> configClass;
    private String configPath;

    public static ConfigService getInstance(){
        if(instance==null){
            instance=new ConfigService();
        }
        return instance;
    }

    public void setValue(Class<?> clazz){
        this.configClass=clazz;
        final ConfigClass annotation=configClass.getAnnotation(ConfigClass.class);
        if(annotation==null){
            throw new IllegalArgumentException("Class: "+clazz+" didn't have 'ConfigClass' annotation");
        }
        this.configPath=annotation.configPath();
    }

    public void addFieldValue() throws IllegalAccessException{
        final List<Field> annotatedFields= Arrays.stream(configClass.getDeclaredFields())
                .filter(i->i.isAnnotationPresent(ConfigProperty.class))
                .collect(Collectors.toList());
        for(Field field:annotatedFields){
            final Config config=new Config(field);
            final Properties properties=ConfigReader.getInstance().readConfig(configPath+config.getConfigName());
            final Object value=customConverter(field,properties.getProperty(config.getPropertyName()));
            config.getField().setAccessible(true);
            config.getField().set(configClass,value);
            config.getField().setAccessible(false);
        }
    }

    private Object customConverter(Field field,String variable){
        final String variableType=field.getType().getSimpleName().toLowerCase();
        switch (variableType){
            case "byte":
                return Byte.parseByte(variable);
            case "short":
                return Short.parseShort(variable);
            case  "integer":
                return Integer.parseInt(variable);
            case "long":
                return Long.parseLong(variable);
            case "float":
                return Float.parseFloat(variable);
            case "double":
                return Double.parseDouble(variable);
            case "boolean":
                return Boolean.parseBoolean(variable);
            case "character":
                return variable.charAt(0);
            default:
                return variable;
        }
    }
}
