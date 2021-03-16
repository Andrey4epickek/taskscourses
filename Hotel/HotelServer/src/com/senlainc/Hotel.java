package com.senlainc;

import com.senlainc.api.dao.IGuestDao;
import com.senlainc.api.dao.IMaintenanceDao;
import com.senlainc.api.dao.IOrderDao;
import com.senlainc.api.dao.IRoomDao;
import com.senlainc.api.service.IGuestService;
import com.senlainc.api.service.IMaintenanceService;
import com.senlainc.api.service.IOrderService;
import com.senlainc.api.service.IRoomService;
import com.senlainc.config.CustomLogger;
import com.senlainc.dao.GuestDao;
import com.senlainc.dao.MaintenanceDao;
import com.senlainc.dao.OrderDao;
import com.senlainc.dao.RoomDao;
import com.senlainc.model.*;
import com.senlainc.service.GuestService;
import com.senlainc.service.MaintenanceService;
import com.senlainc.service.OrderService;
import com.senlainc.service.RoomService;

import java.time.LocalDate;

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
        new CustomLogger();
//        System.out.println(roomDao.getAll());
//        System.out.println(orderDao.getAll());

//        Guest guest1= guestService.addGuest("Vasya",34);
//        System.out.println(guestDao.getByid(1));
//
//        Room roomx=roomService.addRoom(1,3,30,5, RoomStatus.OPEN);
//        System.out.println(roomx);
//
//        Guest guest2=guestService.addGuest("Ivan",40);
//        System.out.println(guestDao.getByid(2));



//        Maintenance maintenance=maintenanceService.addService("lunch",15);
//
//        Order order=orderService.create(roomx,guest1, LocalDate.of(2020,02,17),LocalDate.of(2020,02,28));
//        orderService.checkIn(2,1);
//        System.out.println(order);
//
//        orderService.evict(2,1,1);
//        System.out.println(order);
//
//        roomService.changeStatus(RoomStatus.CLOSED,1);
//        System.out.println(order);
//
//        roomService.changePrice(1,45);
//        System.out.println(order);
//
//        Guest guest3=guestService.addGuest("Andrey",40);
//
//        Room room1=roomService.addRoom(2,1,30,4, RoomStatus.OPEN);
//
//        Order order1=orderService.create(room1,guest3,LocalDate.of(2020,02,17),LocalDate.of(2020,02,24));
//
//        Guest guest4=guestService.addGuest("Alexandr",45);
//        orderService.checkIn(4,2);
//
//        orderService.evict(2,2,2);
//        orderService.evict(1,2,2);
//        System.out.println(order1);
//
//        orderService.countCost(2);
//
//        Maintenance maintenance1=maintenanceService.addService("dinner",10);
//        orderService.addService(maintenance1,2);
//        System.out.println(order1);
//
//        orderService.getOrder(2);
//        orderService.getSortedGuestsByName();
//        orderService.ordersSortedByCheckOutDate();
//        orderService.getFreeRoomByFixedDate(LocalDate.of(2020,02,27));
//        orderService.getQuantityGuests();
//        orderService.getThreeLastGuests(1);
//        orderService.getGuestServicesSortByPrice(2);
//        orderService.getAllOrdersId();
//
//        roomService.getSortRoomByPrice();
//        roomService.getSortRoomByCapacity();
//        roomService.getSortRoomByStars();
//        roomService.getAllRoomsId();


    }
}
