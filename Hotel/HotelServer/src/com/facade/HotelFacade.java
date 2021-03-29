package com.facade;

import com.dao.GuestDao;
import com.dao.MaintenanceDao;
import com.dao.OrderDao;
import com.dao.RoomDao;
import com.model.*;
import com.service.GuestService;
import com.service.MaintenanceService;
import com.service.OrderService;
import com.service.RoomService;
import com.util.SerializationHandler;

import java.time.LocalDate;
import java.util.List;

public class HotelFacade {

    private static HotelFacade instance;
    public static HotelFacade getInstance(){
        if(instance==null){
            instance=new HotelFacade();
        }
        return instance;
    }

     /**
     *Guest
     */
    public Guest addGuest(String name, Integer age){
        Guest guest=GuestService.getInstance().addGuest(name, age);
        return guest;
    }


    public Guest getGuest(Integer guestId){
        Guest guest= GuestService.getInstance().getGuest(guestId);
        return guest;
    }

    /**
     *Order
     */

    public Maintenance addService(String name, Integer price){
        Maintenance maintenance=MaintenanceService.getInstance().addService(name, price);
        return maintenance;
    }

    public Order createOrder(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate){
        Order order= OrderService.getInstance().create(room, guest, checkInDate, checkOutDate);
        return order;
    }

    public void evict(Integer guestId, Integer orderId,Integer roomId){
        OrderService.getInstance().evict(guestId, orderId, roomId);
    }

    public void checkIn(Integer guestId,Integer roomId){
        OrderService.getInstance().checkIn(guestId, roomId);
    }

    public int countCost(Integer orderId){
        int cost= OrderService.getInstance().countCost(orderId);
        return cost;
    }

    public void addService(Maintenance maintenance,Integer orderId){
        OrderService.getInstance().addService(maintenance, orderId);
    }

    public Order getOrder(Integer orderId){
        Order order=OrderService.getInstance().getOrder(orderId);
        return order;
    }

    public List<Order> getSortedGuestsByName(){
        return OrderService.getInstance().getSortedGuestsByName();
    }

    public List<Order> ordersSortedByCheckOutDate(){
        return OrderService.getInstance().ordersSortedByCheckOutDate();
    }

    public List<Order> getThreeLastGuests(Integer roomId){
        return OrderService.getInstance().getThreeLastGuests(roomId);
    }

    /**
     *Room
     */

    public List<Room> getFreeRoomByFixedDate(LocalDate date){
        return OrderService.getInstance().getFreeRoomByFixedDate(date);
    }

    public Room getById(Integer roomId){return RoomService.getInstance().getById(roomId);}

    public void changeStatus(RoomStatus status, Integer roomId){
        RoomService.getInstance().changeStatus(status, roomId);
    }

    public void changePrice(Integer roomId, Integer price){
        RoomService.getInstance().changePrice(roomId, price);
    }

    public List<Room> getSortRoomByPrice(){
        return RoomService.getInstance().getSortRoomByPrice();
    }

    public List<Room> getSortRoomByCapacity(){
        return RoomService.getInstance().getSortRoomByCapacity();
    }

    public List<Room> getSortRoomByStars(){
        return RoomService.getInstance().getSortRoomByStars();
    }

    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars,RoomStatus status,Integer guestId){
        Room room=RoomService.getInstance().addRoom(number, capacity, price, stars,status,guestId);
        return room;
    }

    public Room getRoom(Integer roomId){
        Room room = RoomService.getInstance().getRoom(roomId);
        return room;
    }

    public void saveToFile(){
        List<Guest> guests= GuestDao.getInstance().getAll();
        List<Room> rooms=RoomDao.getInstance().getAll();
        List<Order> orders=OrderDao.getInstance().getAll();
        List<Maintenance> maintenances=MaintenanceDao.getInstance().getAll();
        SerializationHandler.serialize(guests,rooms,orders,maintenances);
    }


}
