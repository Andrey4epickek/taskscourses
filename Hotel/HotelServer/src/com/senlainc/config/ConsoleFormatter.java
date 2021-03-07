package com.senlainc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class ConsoleFormatter {
    static {
        try(InputStream configReader = new FileInputStream("task-3.4/resources/logger.properties")){
            LogManager.getLogManager().readConfiguration(configReader);
        }catch (IOException e){
            System.err.println("Could not setup logger configuration" + e.toString());
        }
    }
}
