package facade;

import api.dao.IGuestDao;
import api.dao.IMaintenanceDao;
import api.dao.IOrderDao;
import api.dao.IRoomDao;
import api.service.IGuestService;
import api.service.IMaintenanceService;
import api.service.IOrderService;
import api.service.IRoomService;
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

public class HotelFacade {
    private static final IGuestDao guestDao=new GuestDao();
    private static final IGuestService guestService=new GuestService(guestDao);

    private static final IRoomDao roomDao=new RoomDao();
    private static final IRoomService roomService=new RoomService(roomDao,guestDao);

    private static final IMaintenanceDao maintenanceDao=new MaintenanceDao();
    private static final IOrderDao orderDao=new OrderDao();
    private static final IOrderService orderService=new OrderService(roomDao, guestDao,maintenanceDao,orderDao);

    private static final IMaintenanceService maintenanceService=new MaintenanceService(maintenanceDao,orderDao);

    private static HotelFacade instance;
    public static HotelFacade getInstance(){
        if(instance==null){
            instance=new HotelFacade();
        }
        return instance;
    }

    public Guest addGuest(String name, Integer age){
        Guest guest=guestService.addGuest(name, age);
        return guest;
    }

    public List<Integer> getAllGuestId(){
        return guestService.getAllGuestId();
    }

    public Guest getGuest(Integer guestId){
        Guest guest= guestService.getGuest(guestId);
        return guest;
    }

    public Maintenance addService(String name, Integer price){
        Maintenance maintenance=maintenanceService.addService(name, price);
        return maintenance;
    }

    public Order createOrder(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate){
        Order order=orderService.create(room, guest, checkInDate, checkOutDate);
        return order;
    }

    public void evict(Integer guestId, Integer orderId,Integer roomId){
        orderService.evict(guestId, orderId, roomId);
    }

    public void checkIn(Integer guestId,Integer roomId){
        orderService.checkIn(guestId, roomId);
    }

    public int countCost(Integer orderId){
        int cost= orderService.countCost(orderId);
        return cost;
    }

    public void addService(Maintenance maintenance,Integer orderId){
        orderService.addService(maintenance, orderId);
    }

    public Order getOrder(Integer orderId){
        Order order=orderService.getOrder(orderId);
        return order;
    }

    public List<Order> getSortedGuestsByName(){
        return orderService.getSortedGuestsByName();
    }

    public List<Order> ordersSortedByCheckOutDate(){
        return orderService.ordersSortedByCheckOutDate();
    }

    public List<Room> getFreeRoomByFixedDate(LocalDate date){
        return orderService.getFreeRoomByFixedDate(date);
    }

    public void changeStatus(RoomStatus status,Integer roomId){
        roomService.changeStatus(status, roomId);
    }

    public void changePrice(Integer roomId, Integer price){
        roomService.changePrice(roomId, price);
    }

    public List<Room> getSortRoomByPrice(){
        return roomService.getSortRoomByPrice();
    }

    public List<Room> getSortRoomByCapacity(){
        return roomService.getSortRoomByCapacity();
    }

    public List<Room> getSortRoomByStars(){
        return roomService.getSortRoomByStars();
    }

    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars,RoomStatus status){
        Room room=roomService.addRoom(number, capacity, price, stars,status);
        return room;
    }


}
