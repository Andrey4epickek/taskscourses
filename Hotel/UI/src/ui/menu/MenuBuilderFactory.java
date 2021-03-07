package ui.menu;

import ui.actions.guest.AddGuest;
import ui.actions.guest.GetAllGuestId;
import ui.actions.guest.GetGuest;
import ui.actions.maintenance.AddMaintenance;
import ui.actions.order.*;
import ui.actions.room.*;

public class MenuBuilderFactory {

    private static final String BACK_TO_PREVIOUS ="Back to previous menu";

    public Menu mainMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Guest actions",null,guestMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Room actions",null,roomMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Order actions",null,orderMenu(new Menu(),rootMenu)))
                .addItem(new MenuItem("Maintenance actions",null,maintenanceMenu(new Menu(),rootMenu)))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");

    }
    public Menu guestMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add guest",new AddGuest(),rootMenu))
                .addItem(new MenuItem("Get all guest id",new GetAllGuestId(),rootMenu))
                .addItem(new MenuItem("Get guest",new GetGuest(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }
    public Menu maintenanceMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add maintenance",new AddMaintenance(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }
    public Menu roomMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Add  room",new AddRoom(),rootMenu))
                .addItem(new MenuItem("Change price",new ChangePrice(),rootMenu))
                .addItem(new MenuItem("Change status",new ChangeStatus(),rootMenu))
                .addItem(new MenuItem("Sort by capacity",new GetSortRoomByCapacity(),rootMenu))
                .addItem(new MenuItem("Sort by price",new GetSortRoomByPrice(),rootMenu))
                .addItem(new MenuItem("Sort by stars",new GetSortRoomByStars(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }
    public Menu orderMenu(Menu rootMenu,Menu previousMenu){
        return new MenuBuilder(rootMenu)
                .addItem(new MenuItem("Create order",new CreateOrder(),rootMenu))
                .addItem(new MenuItem("Add service to room",new AddService(),rootMenu))
                .addItem(new MenuItem("CheckIn guest",new CheckIn(),rootMenu))
                .addItem(new MenuItem("CountCost of order",new CountCost(),rootMenu))
                .addItem(new MenuItem("Evict guest",new Evict(),rootMenu))
                .addItem(new MenuItem("Get free room by date",new GetFreeRoomByDate(),rootMenu))
                .addItem(new MenuItem("Get order",new GetOrder(),rootMenu))
                .addItem(new MenuItem("Sort by date",new GetSortedByDate(),rootMenu))
                .addItem(new MenuItem("Sort by name",new GetSortedByName(),rootMenu))
                .addItem(previousMenu==null?null:new MenuItem(BACK_TO_PREVIOUS,null,previousMenu))
                .build("Hotel Application menu (0-Exit)");
    }

}
