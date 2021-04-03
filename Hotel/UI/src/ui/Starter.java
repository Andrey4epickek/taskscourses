package ui;


import com.Load.LoadConfig;
import com.Load.LoadData;
import com.config.CustomLogger;

import com.configuration.ConfigController;
import com.facade.HotelFacade;
import ui.menu.MenuController;

public class Starter {

    public static void main(String[] args) {
       new CustomLogger();
        ConfigController.getInstance().setConfig(LoadConfig.class);
        System.out.println(LoadConfig.getStatus());
        System.out.println(LoadConfig.getHistory());
//        LoadData.execute(HotelFacade.class);
        MenuController.getInstance().run();

    }
}
