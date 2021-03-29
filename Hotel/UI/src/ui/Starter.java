package ui;


import com.Load.LoadConfig;
import com.config.CustomLogger;

import com.configuration.ConfigController;
import ui.menu.MenuController;

public class Starter {

    public static void main(String[] args) {
       new CustomLogger();
        ConfigController.getInstance().setConfig(LoadConfig.class);
        System.out.println(LoadConfig.getStatus());
        System.out.println(LoadConfig.getHistory());
        MenuController.getInstance().run();

    }
}
