

import com.hotel.ui.menu.MenuController;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {

//            new CustomLogger();
//            ConfigController.getInstance().setConfig(LoadConfig.class);
//            System.out.println(LoadConfig.getStatus());
//            System.out.println(LoadConfig.getHistory());
              MenuController.getInstance().run();

//                EntityManager entityManager=emu.getEntityManager();
//                GuestDao guestDao=new GuestDao(entityManager);
//                RoomDao roomDao=new RoomDao(entityManager);
//                Room room=new Room();
//                room.setNumber(101);
//                room.setCapacity(3);
//                room.setPrice(44);
//                room.setStars(4);
//                emu.beginTransaction();
//                roomDao.save(room);
//                emu.commit();
//
//
//                Guest guest2=new Guest();
//                guest2.setName("dfgdfg");
//                guest2.setAge(15);
//                guest2.setRoom(room);
//                emu.beginTransaction();
//                guestDao.save(guest2);
//                emu.commit();

//                MaintenanceDao maintenanceDao=new MaintenanceDao(entityManager);
//                Order order=new Order();
//                order.setCheckInDate(LocalDate.of(2021,05,12));
//                order.setCheckOutDate(LocalDate.of(2021,05,17));
//                order.setRoom(room);
//                order.setGuest(guest1);
//                order.setCost(10);
//
//                Maintenance maintenance1=new Maintenance();
//                maintenance1.setName("lunch");
//                maintenance1.setPrice(10);
//                maintenance1.setOrder(order);
//                emu.beginTransaction();
//                maintenanceDao.save(maintenance1);
//                emu.commit();

//        System.out.println(applicationContext.roomDao().getByid(2));
//            Guest guest=applicationContext.guestService().addGuest("vasya",20);
//            System.out.println(guest);
//            System.out.println(applicationContext.guestDao().getAll());
//
//            Room room=applicationContext.roomService().addRoom(1,3,30,3, RoomStatus.OPEN,1);
//            System.out.println(room);
//            System.out.println(applicationContext.roomDao().getByid(1));
        }

}


