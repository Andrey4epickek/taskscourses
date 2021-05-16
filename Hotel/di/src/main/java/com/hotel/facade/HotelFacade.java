package com.hotel.facade;

import com.hotel.api.service.IGuestService;
import com.hotel.api.service.IMaintenanceService;
import com.hotel.api.service.IOrderService;
import com.hotel.api.service.IRoomService;
import com.hotel.injection.ApplicationContext;
import com.hotel.model.*;
import com.hotel.SerializationHandler;

import java.time.LocalDate;
import java.util.List;


public class HotelFacade {

    private ApplicationContext applicationContext=ApplicationContext.getInstance();
    private  IGuestService guestService;

    private  IRoomService roomService;

    private  IOrderService orderService;

    private  IMaintenanceService maintenanceService;

    public HotelFacade(IGuestService guestService, IRoomService roomService, IOrderService orderService, IMaintenanceService maintenanceService) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.orderService = orderService;
        this.maintenanceService = maintenanceService;
    }

    /**
     *Guest
     */
    public Guest addGuest(String name, Integer age,Room room){
        Guest guest=applicationContext.guestService().addGuest(name, age,room);
        return guest;
    }


    public Guest getGuest(Integer guestId){
        Guest guest= applicationContext.guestService().getGuest(guestId);
        return guest;
    }

    public int getQuantityOfGuest(){
        return applicationContext.guestService().getQuantityGuests();
    }

    public List<Guest> getAllGuests(){
        return applicationContext.guestService().getAllGuestService();
    }

    /**
     *Maintenance
     */

    public Maintenance addService(String name, Integer price,Order order){
        Maintenance maintenance= applicationContext.maintenanceService().addService(name, price,order);
        return maintenance;
    }

    public List<Maintenance> getAllServices(){
        return applicationContext.maintenanceService().getAllServices();
    }

    /**
     *Order
     */

    public Order createOrder(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate){
        Order order= applicationContext.orderService().create(room, guest, checkInDate, checkOutDate);
        return order;
    }

    public void evict(Integer guestId, Integer orderId,Integer roomId){
        applicationContext.orderService().evict(guestId, orderId, roomId);
    }

    public void checkIn(Integer guestId,Integer roomId){
        applicationContext.orderService().checkIn(guestId, roomId);
    }

    public int countCost(Integer orderId){
        int cost= applicationContext.orderService().countCost(orderId);
        return cost;
    }

    public void addService(Integer maintenanceId,Integer orderId){
        applicationContext.orderService().addService(maintenanceId, orderId);
    }

    public Order getOrder(Integer orderId){
        Order order=applicationContext.orderService().getOrder(orderId);
        return order;
    }

    public List<Order> getSortedGuestsByName(){
        return applicationContext.orderService().getSortedGuestsByName();
    }

    public List<Order> ordersSortedByCheckOutDate(){
        return applicationContext.orderService().ordersSortedByCheckOutDate();
    }

    public List<Order> getThreeLastGuests(Integer roomId){
        return applicationContext.orderService().getThreeLastGuests(roomId);
    }

    public List<Maintenance> getGuestServicesSortByPrice(Integer orderId){
        return applicationContext.orderService().getGuestServicesSortByPrice(orderId);
    }

    /**
     *Room
     */

    public List<Room> getFreeRoomByFixedDate(LocalDate date){
        return applicationContext.orderService().getFreeRoomByFixedDate(date);
    }

    public  Room getById(Integer roomId){return applicationContext.roomService().getById(roomId);}

    public void changeStatus(RoomStatus status, Integer roomId){
        applicationContext.roomService().changeStatus(status, roomId);
    }

    public void changePrice(Integer roomId, Integer price){
        applicationContext.roomService().changePrice(roomId, price);
    }

    public List<Room> getSortRoomByPrice(){
        return applicationContext.roomService().getSortRoomByPrice();
    }

    public List<Room> getSortRoomByCapacity(){
        return applicationContext.roomService().getSortRoomByCapacity();
    }

    public List<Room> getSortRoomByStars(){
        return applicationContext.roomService().getSortRoomByStars();
    }

    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars,RoomStatus status){
        Room room=applicationContext.roomService().addRoom(number, capacity, price, stars,status);
        return room;
    }

    public Room getRoom(Integer roomId){
        Room room = applicationContext.roomService().getRoom(roomId);
        return room;
    }

//    public void saveToFile(){
//        List<Guest> guests= applicationContext.guestDao().getAll();
//        List<Room> rooms=applicationContext.roomDao().getAll();
//        List<Order> orders=applicationContext.orderDao().getAll();
//        List<Maintenance> maintenances=applicationContext.maintenanceDao().getAll();
//        SerializationHandler.serialize(guests,rooms,orders,maintenances);
//    }


}
