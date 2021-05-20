package com.hotel.controller;

import com.hotel.api.service.IGuestService;
import com.hotel.api.service.IRoomService;
import com.hotel.configuration.ContextConfiguration;
import com.hotel.model.Guest;
import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainController {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);
        IRoomService roomService=context.getBean("roomService",IRoomService.class);
        IGuestService guestService=context.getBean("guestService",IGuestService.class);
        Room room1=roomService.getById(4);
        System.out.println(room1);

//        Room room2= roomService.addRoom(4,4,50,4, RoomStatus.OPEN);
//
//        Guest guest1= guestService.addGuest("boba",15,room2);

//        roomService.changePrice(11,40);
//        Room room2=roomService.getById(11);
//        System.out.println(room2);
//        guestService.deleteGuest(1);

    }
}
