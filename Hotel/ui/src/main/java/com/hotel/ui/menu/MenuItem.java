package com.hotel.ui.menu;

import com.hotel.ui.actions.IAction;

import java.io.IOException;

public class MenuItem {

    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public String getTitle() {
        return title;
    }

    public IAction getAction() {
        return action;
    }

    public void doAction() throws IOException {
        action.execute();
    }

    public Menu getNextMenu(){
        return nextMenu;
    }
}
