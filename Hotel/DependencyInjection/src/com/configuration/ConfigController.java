package com.configuration;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConfigController {
    private static final Logger LOGGER= LogManager.getLogManager().getLogger(ConfigController.class.getName());
    private static ConfigController instance;

    public static ConfigController getInstance() {
        if (instance == null) {
            instance = new ConfigController();
        }
        return instance;
    }

    public void setConfig(Class<?> clazz){
        try{
            ConfigService.getInstance().setValue(clazz);
            ConfigService.getInstance().addFieldValue();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
