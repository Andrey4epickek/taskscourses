
import com.hotel.Load.LoadConfig;
import com.hotel.config.CustomLogger;
import com.hotel.configuration.ConfigController;
import com.hotel.dao.GuestDao;
import com.hotel.dao.MaintenanceDao;
import com.hotel.dao.util.EntityManagerUtil;
import com.hotel.injection.ApplicationContext;
import com.hotel.model.*;
import com.hotel.ui.menu.MenuController;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class Starter {
    private static final ApplicationContext applicationContext=ApplicationContext.getInstance();
    private static final EntityManagerUtil emu=new EntityManagerUtil();
    public static void main(String[] args) throws IOException {

//            new CustomLogger();
//            ConfigController.getInstance().setConfig(LoadConfig.class);
//            System.out.println(LoadConfig.getStatus());
//            System.out.println(LoadConfig.getHistory());
//            MenuController.getInstance().run();
                EntityManager entityManager=emu.getEntityManager();
                GuestDao guestDao=new GuestDao(entityManager);
                Room room=new Room();
                room.setNumber(101);

                Guest guest1=new Guest();
                guest1.setName("name");
                guest1.setAge(1500);
                guest1.setRoom(room);

                emu.beginTransaction();
                guestDao.save(guest1);
                emu.commit();

                MaintenanceDao maintenanceDao=new MaintenanceDao(entityManager);
                Order order=new Order();
                order.setCheckInDate(LocalDate.of(2021,05,12));
                order.setCheckOutDate(LocalDate.of(2021,05,17));
                order.setRoom(room);
                order.setGuest(guest1);
                order.setCost(10);

                Maintenance maintenance1=new Maintenance();
                maintenance1.setName("lunch");
                maintenance1.setPrice(10);
                maintenance1.setOrder(order);
                emu.beginTransaction();
                maintenanceDao.save(maintenance1);
                emu.commit();

//        System.out.println(applicationContext.guestDao().getByid(5));
//            Guest guest=applicationContext.guestService().addGuest("vasya",20);
//            System.out.println(guest);
//            System.out.println(applicationContext.guestDao().getAll());
//
//            Room room=applicationContext.roomService().addRoom(1,3,30,3, RoomStatus.OPEN,1);
//            System.out.println(room);
//            System.out.println(applicationContext.roomDao().getByid(1));
        }

}


