package com.senlainc.config;

import java.io.FileInputStream;
import java.util.logging.Logger;
import java.util.logging.LogManager;

public class FileFormatter {
    static Logger LOGGER;
    static {
        try(FileInputStream configreader = new FileInputStream("HotelServer/resources/logger.properties")){
            LogManager.getLogManager().readConfiguration(configreader);
            LOGGER = Logger.getLogger(FileFormatter.class.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
