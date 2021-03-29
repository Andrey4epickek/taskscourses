package com.injection.utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;


public class DependencyController {

    private static final Logger LOGGER = LogManager.getLogger(DependencyController.class.getName());
    private static DependencyController instance;

    public static DependencyController getInstance() {
        if (instance == null) {
            instance = new DependencyController();
        }
        return instance;
    }

    public void setDependency(Class<?> clazz)  {
        try {
            DependencyService.getInstance().setVariable(clazz);
            DependencyService.getInstance().initializeConstructor();
            LOGGER.debug(MessageFormat.format("Successful load class: {}", clazz.getSimpleName()));
        } catch (NoSuchMethodException  | IllegalAccessException | InvocationTargetException | InstantiationException | IllegalArgumentException |IllegalStateException | ClassCastException e) {
            LOGGER.warn(MessageFormat.format("Could load class: {0}, reason: {1}",clazz,e.getMessage()),e);
        }
    }

    public Object getClazz(Class<?> clazz){return DependencyService.getInstance().getInstanceClass(clazz);}
}

