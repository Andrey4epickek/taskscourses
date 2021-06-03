package com.hotel;

import com.hotel.exceptions.ServiceException;
import com.hotel.model.AEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class SerializationHandler {
    private static final Logger LOGGER = LogManager.getLogger(SerializationHandler.class.getName());
    private static final String PATH_TO_FILE= PropertiesHandler.getProperty("server.serialization.path_to_file")
            .orElseThrow(()->new ServiceException("Serialization file path not found"));

    @SafeVarargs
    public static void serialize(List<? extends AEntity> ... entities){
        List<List<? extends AEntity>> marshalingList=List.of(entities);
        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(PATH_TO_FILE))){
            outputStream.writeObject(marshalingList);
        }catch (IOException e){
            LOGGER.warn("Serialization to file failed " + e.getLocalizedMessage());
            throw new ServiceException(e);
        }
    }

    public static <T> List<T> deserialize(Class<T> clazz){
        try(ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(PATH_TO_FILE))){
            List<List<? extends AEntity>> list =(List<List<? extends AEntity>>) inputStream.readObject();
            for (List<? extends AEntity> entities:list){
                if(!entities.isEmpty()&&entities.get(0).getClass().equals(clazz)){
                    return (List<T>) entities;
                }
            }
        }catch (IOException|ClassNotFoundException e){
            LOGGER.warn("Deserialization failed " +e.getLocalizedMessage());
            throw new ServiceException(e);
        }
        return Collections.emptyList();
    }
}
