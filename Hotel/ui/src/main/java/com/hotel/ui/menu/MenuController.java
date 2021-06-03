package com.hotel.ui.menu;

import com.hotel.injection.ApplicationContext;

import java.util.Objects;
import java.util.Scanner;

public class MenuController {

    private static MenuController instance;
    private Builder builder;
    private Navigator navigator;
    private ApplicationContext applicationContext;

    private MenuController() {
        builder=Builder.getInstance();
        builder.buildMenu();
        navigator=Navigator.getInstance();
        applicationContext=new ApplicationContext();
    }

    public static MenuController getInstance() {
        instance=Objects.requireNonNullElse(instance,new MenuController());
        return instance;
    }

    public void run(){
        Scanner scanner=new Scanner(System.in);
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Integer index=-1;
        while (!index.equals(0)){
            index=scanner.nextInt();
            navigator.navigate(index);
            navigator.printMenu();
        }
    }
}
