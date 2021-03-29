package com.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static ConfigReader instance;

    public static ConfigReader getInstance(){
        if(instance==null){
            instance=new ConfigReader();
        }
        return instance;
    }

    public Properties readConfig(String s){
        Properties properties=new Properties();
        try {
           InputStream input = new FileInputStream(s);
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
