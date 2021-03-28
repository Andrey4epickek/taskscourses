package ui;

import com.senlainc.config.CustomLogger;
import ui.menu.MenuController;

public class Starter {

    public static void main(String[] args) {
       new CustomLogger();
        MenuController.getInstance().run();
    }
}
