package com.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class CustomLogger {
    static {
        Logger logger = Logger.getLogger(CustomLogger.class.getPackage().getName());
        try(InputStream configReader = new FileInputStream("HotelServer/resources/logger.properties")){
            LogManager.getLogManager().readConfiguration(configReader);
            Handler consoleHandler=new ConsoleHandler();
            Handler fileHandler=new FileHandler();
            consoleHandler.setFormatter(new ConsoleFormatter());
            fileHandler.setFormatter(new FileFormatter());
            logger.addHandler(fileHandler);
        }catch (IOException e){
            System.err.println("Could not setup logger configuration" + e.toString());
        }
    }
}
