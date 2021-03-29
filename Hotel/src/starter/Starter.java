package starter;

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

//        Boolean prop= PropertiesHandler.getProperty("server.room.change_status.enable")
//                .map(Boolean::valueOf)
//                .orElse(false);
//        System.out.println(prop);
//
//        Boolean prop1= PropertiesHandler.getProperty("server.order.history.enable")
//                .map(Boolean::valueOf)
//                .orElse(false);
//        System.out.println(prop1);



//        List<Guest> guests=List.of(new Guest("vasya",20),new Guest("andrey",19));
//        List<Room> rooms=List.of(new Room(1,2,30, RoomStatus.OPEN,4,guests));
//        List<Order> orders=List.of(new Order());
//        SerializationHandler.serialize(orders);

//        List<Guest> g2 =SerializationHandler.deserialize(Guest.class);
//        System.out.println(g2);
//
//        List<Room> r2 =SerializationHandler.deserialize(Room.class);
//        System.out.println(r2);
//        List<Order> o2 =SerializationHandler.deserialize(Order.class);
//        System.out.println(o2);
    }

}
