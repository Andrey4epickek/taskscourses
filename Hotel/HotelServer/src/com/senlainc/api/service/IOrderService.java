package com.senlainc.api.service;

import com.senlainc.model.Guest;
import com.senlainc.model.Maintenance;
import com.senlainc.model.Order;
import com.senlainc.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order create(Room room, Guest guest, LocalDate checkInDate,LocalDate checkOutDate);
    void evict(Integer guestId,Integer orderId,Integer roomId);
    void checkIn(Integer guestId, Integer roomId);
    int countCost(Integer orderId);
    void addService( Maintenance maintenance,Integer orderId);
    Order getOrder(Integer orderId);
    List<Order> getSortedGuestsByName();
    List<Order> ordersSortedByCheckOutDate();
    int getQuantityGuests();
    List<Order> getAllOrderService();
    List<Guest> getAllGuestService();
    List<Room> getFreeRoomByFixedDate(LocalDate date);
    List<Maintenance> getGuestServicesSortByPrice(Integer orderId);
    List<Order> getThreeLastGuests(Integer roomId);
    List<Integer> getAllOrdersId();
}
