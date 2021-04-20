package com;


import com.api.dao.IGuestDao;
import com.api.service.IGuestService;
import com.config.CustomLogger;
import com.injection.ApplicationContext;
import com.model.*;
import com.service.GuestService;

import java.time.LocalDate;


public class Hotel {
    private static final ApplicationContext applicationContext=ApplicationContext.getInstance();

    public static void main(String[] args) {
        new CustomLogger();

//        Maintenance maintenance=applicationContext.maintenanceService().addService("lunch",10);
//        System.out.println(maintenance);
//        Maintenance maintenance1=applicationContext.maintenanceService().addService("dinner",10);
//        System.out.println(maintenance1);
//        System.out.println(applicationContext.maintenanceDao().getAll());

//        Guest guest=applicationContext.guestService().addGuest("vasya",20);
//        System.out.println(guest);
//        Guest guest2=applicationContext.guestService().addGuest("andrey",23);
//        System.out.println(guest2);
//        System.out.println(applicationContext.guestDao().getByid(1));
//        System.out.println(applicationContext.guestDao().getByIdList(1));
//        applicationContext.guestService().deleteGuest(3);
        System.out.println(applicationContext.guestDao().getAll());
//
//        Room room=applicationContext.roomService().addRoom(1,3,30,3, RoomStatus.OPEN,1);
//        System.out.println(room);
//        applicationContext.roomService().changePrice(1,35);
        System.out.println(applicationContext.roomDao().getAll());

//        Order order=applicationContext.orderService().create(room,guest, LocalDate.of(2020,04,19),LocalDate.of(2020,04,25));
//        System.out.println(order);
        System.out.println(applicationContext.orderDao().getAll());
//        System.out.println(RoomDao.getInstance().getAll());
//        System.out.println(OrderDao.getInstance().getAll());
//
//        Guest guest1= GuestService.getInstance().addGuest("Vasya",34);
//        System.out.println(GuestDao.getInstance().getByid(1));
//
//        Room roomx=RoomService.getInstance().addRoom(1,3,30,5, RoomStatus.OPEN);
//        System.out.println(roomx);
//
//        Guest guest2=GuestService.getInstance().addGuest("Ivan",40);
//        System.out.println(GuestDao.getInstance().getByid(2));
//
//
//
//        Maintenance maintenance=MaintenanceService.getInstance().addService("lunch",15);
//
//        Order order=OrderService.getInstance().create(roomx,guest1, LocalDate.of(2020,02,17),LocalDate.of(2020,02,28));
//        OrderService.getInstance().checkIn(2,1);
//        System.out.println(order);
//
//        OrderService.getInstance().evict(2,1,1);
//        System.out.println(order);
//
//        RoomService.getInstance().changeStatus(RoomStatus.CLOSED,1);
//        System.out.println(order);
//
//        RoomService.getInstance().changePrice(1,45);
//        System.out.println(order);
//
//        Guest guest3=GuestService.getInstance().addGuest("Andrey",40);
//
//        Room room1=RoomService.getInstance().addRoom(2,1,30,4, RoomStatus.OPEN);
//
//        Order order1=OrderService.getInstance().create(room1,guest3,LocalDate.of(2020,02,17),LocalDate.of(2020,02,24));
//
//        Guest guest4=GuestService.getInstance().addGuest("Alexandr",45);
//        OrderService.getInstance().checkIn(4,2);
//
//        OrderService.getInstance().evict(2,2,2);
//        OrderService.getInstance().evict(1,2,2);
//        System.out.println(order1);
//
//        OrderService.getInstance().countCost(2);
//
//        Maintenance maintenance1=MaintenanceService.getInstance().addService("dinner",10);
//        OrderService.getInstance().addService(maintenance1,2);
//        System.out.println(order1);
//
//        OrderService.getInstance().getOrder(2);
//        OrderService.getInstance().getSortedGuestsByName();
//        OrderService.getInstance().ordersSortedByCheckOutDate();
//        OrderService.getInstance().getFreeRoomByFixedDate(LocalDate.of(2020,02,27));
//        OrderService.getInstance().getQuantityGuests();
//        OrderService.getInstance().getThreeLastGuests(1);
//        OrderService.getInstance().getGuestServicesSortByPrice(2);
//        OrderService.getInstance().getAllOrdersId();
//
//        RoomService.getInstance().getSortRoomByPrice();
//        RoomService.getInstance().getSortRoomByCapacity();
//        RoomService.getInstance().getSortRoomByStars();
//        RoomService.getInstance().getAllRoomsId();


    }
}
