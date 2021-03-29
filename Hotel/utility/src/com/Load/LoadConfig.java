package com.Load;

import com.configuration.ConfigController;
import com.configuration.annotation.ConfigClass;
import com.configuration.annotation.ConfigProperty;

@ConfigClass
public class LoadConfig {
    @ConfigProperty(configName = "/application.properties")
    private static Boolean status;
    @ConfigProperty(configName = "/application.properties")
    private static Boolean history;
   private LoadConfig(){
       ConfigController.getInstance().setConfig(LoadConfig.class);
   }

    public static Boolean getHistory() {
        return history;
    }

    public static Boolean getStatus() {
        return status;
    }
}
