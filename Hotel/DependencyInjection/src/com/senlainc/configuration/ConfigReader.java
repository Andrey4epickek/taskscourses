package com.senlainc.configuration;

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

        return null;
    }
}
