package com.Load;

import com.injection.utility.DependencyController;

public final class LoadData {
    private LoadData(){throw  new IllegalStateException("Utility class");}

    public static void execute(Class<?> clazz){
        DependencyController.getInstance().setDependency(clazz);
    }
}
