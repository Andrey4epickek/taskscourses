import api.dao.IGuestDao;
import api.dao.IMaintenanceDao;
import api.dao.IOrderDao;
import api.dao.IRoomDao;
import api.service.IGuestService;
import api.service.IMaintenanceService;
import api.service.IOrderService;
import api.service.IRoomService;
import com.sun.security.jgss.GSSUtil;
import dao.GuestDao;
import dao.MaintenanceDao;
import dao.OrderDao;
import dao.RoomDao;
import model.*;
import service.GuestService;
import service.MaintenanceService;
import service.OrderService;
import service.RoomService;

import java.time.LocalDate;
import java.util.List;


public class Hotel {
    private static final IGuestDao guestDao=new GuestDao();
    private static final IGuestService guestService=new GuestService(guestDao);

    private static final IRoomDao roomDao=new RoomDao();
    private static final IRoomService roomService=new RoomService(roomDao,guestDao);

    private static final IMaintenanceDao maintenanceDao=new MaintenanceDao();
    private static final IOrderDao orderDao=new OrderDao();
    private static final IOrderService orderService=new OrderService(roomDao, guestDao,maintenanceDao,orderDao);

    private static final IMaintenanceService maintenanceService=new MaintenanceService(maintenanceDao,orderDao);


    public static void main(String[] args) {
        Guest guest1= guestService.addGuest("Vasya",34);
        System.out.println(guestDao.getByid(1L));

        Room roomx=roomService.addRoom(1,3,30,5, RoomStatus.OPEN);
        System.out.println(roomx);

        Guest guest2=guestService.addGuest("Ivan",40);
        System.out.println(guestDao.getByid(2L));



        Maintenance maintenance=maintenanceService.addService("lunch",15);

        Order order=orderService.create(roomx,guest1, LocalDate.of(2020,02,17),LocalDate.of(2020,02,28));
        orderService.checkIn(2L,1L);
        System.out.println(order);

        orderService.evict(2L,1L,1L);
        System.out.println(order);

        roomService.changeStatus(RoomStatus.CLOSED,1L);
        System.out.println(order);

        roomService.changePrice(1L,45);
        System.out.println(order);

        Guest guest3=guestService.addGuest("Andrey",40);

        Room room1=roomService.addRoom(2,1,30,4, RoomStatus.OPEN);

        Order order1=orderService.create(room1,guest3,LocalDate.of(2020,02,17),LocalDate.of(2020,02,24));

        Guest guest4=guestService.addGuest("Alexandr",45);
        orderService.checkIn(4L,2L);

        orderService.evict(2L,2L,2L);
        orderService.evict(1L,2L,2L);
        System.out.println(order1);

        orderService.countCost(2L);

        Maintenance maintenance1=maintenanceService.addService("dinner",10);
        orderService.addService(maintenance1,2L);
        System.out.println(order1);

        orderService.getOrder(2L);
        orderService.getSortedGuestsByName();
        orderService.ordersSortedByCheckOutDate();
        orderService.getFreeRoomByFixedDate(LocalDate.of(2020,02,27));
        orderService.getQuantityGuests();
        orderService.getThreeLastGuests(1L);
        orderService.getGuestServicesSortByPrice(2L);
        orderService.getAllOrdersId();

        roomService.getSortRoomByPrice();
        roomService.getSortRoomByCapacity();
        roomService.getSortRoomByStars();
        roomService.getAllRoomsId();


    }
}
