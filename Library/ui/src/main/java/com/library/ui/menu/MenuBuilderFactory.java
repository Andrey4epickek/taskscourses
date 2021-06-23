package com.library.ui.menu;

import com.library.ui.actions.reader.AddReader;

public class MenuBuilderFactory {
    private static final String BACK_TO_PREVIOUS ="Back to previous menu";

    public Menu mainMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Reader actions",null,readerMenu(new Menu(),rootMenu)))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");

    }

    public Menu readerMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add reader",new AddReader(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

}
