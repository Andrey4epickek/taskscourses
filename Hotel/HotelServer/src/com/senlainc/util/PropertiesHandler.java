package com.senlainc.util;

import com.senlainc.exceptions.ServiceException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesHandler {
    private static final Logger LOGGER =Logger.getLogger(PropertiesHandler.class.getName());
    private static final String FAILED_READ_PROPERTIES_ERROR_MESSAGE="Failed to read properties";
    private static Properties properties;
    private static final String PROPERTIES_FILE_PATH="HotelServer/resources/application.properties";

    public PropertiesHandler() {
    }

    public static Optional<String> getProperty(String key){
        if(properties==null){
            loadProperties();
        }
        return Optional.ofNullable(properties.getProperty(key));
    }

    private static void loadProperties(){
        try(InputStream inputStream=new FileInputStream(PROPERTIES_FILE_PATH)){
            properties=new Properties();
            properties.load(inputStream);
        }catch (IOException e){
            LOGGER.warning(FAILED_READ_PROPERTIES_ERROR_MESSAGE+e.getMessage());
            throw new ServiceException(FAILED_READ_PROPERTIES_ERROR_MESSAGE,e);
        }
    }
}
