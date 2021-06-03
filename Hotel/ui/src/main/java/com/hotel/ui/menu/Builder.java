package com.hotel.ui.menu;

import com.hotel.ui.actions.room.AddRoom;

import java.util.Objects;

public class Builder {

    private static Builder instance;
    private Menu rootMenu;


    private Builder(){
        buildMenu();
    }

    public static Builder getInstance(){
        instance=Objects.requireNonNullElse(instance,new Builder());
        return instance;
    }

    public void buildMenu(){
        rootMenu=new MenuBuilderFactory().mainMenu(new Menu(),null);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu createRootMenu(){
        var rootMenu=new Menu();
        rootMenu.addMenuItem(new MenuItem("Какое-то действие",()->{ System.out.println("Просто печатаю в консоль");},rootMenu));
        rootMenu.addMenuItem(new MenuItem("Добавить комнату",new AddRoom(),rootMenu));

        return  rootMenu;
    }
}
