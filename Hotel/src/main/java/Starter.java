
import com.hotel.Load.LoadConfig;
import com.hotel.config.CustomLogger;
import com.hotel.configuration.ConfigController;
import com.hotel.injection.ApplicationContext;
import com.hotel.model.*;
import com.hotel.ui.menu.MenuController;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Starter {
    private static final ApplicationContext applicationContext=ApplicationContext.getInstance();
    public static void main(String[] args) throws IOException {
//            new CustomLogger();
//            ConfigController.getInstance().setConfig(LoadConfig.class);
//            System.out.println(LoadConfig.getStatus());
//            System.out.println(LoadConfig.getHistory());
            MenuController.getInstance().run();
//            Guest guest=applicationContext.guestService().addGuest("vasya",20);
//            System.out.println(guest);
//            System.out.println(applicationContext.guestDao().getAll());
//
//            Room room=applicationContext.roomService().addRoom(1,3,30,3, RoomStatus.OPEN,1);
//            System.out.println(room);
//            System.out.println(applicationContext.roomDao().getByid(1));
        }

}


