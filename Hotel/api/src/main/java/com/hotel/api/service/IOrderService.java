package com.hotel.api.service;

import com.hotel.model.Guest;
import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order create(Room room, Guest guest, LocalDate checkInDate,LocalDate checkOutDate);
    void evict(Integer guestId,Integer orderId,Integer roomId);
    void checkIn(Integer guestId, Integer roomId);
    int countCost(Integer orderId);
    void addService( Integer maintenanceId,Integer orderId);
    Order getOrder(Integer orderId);
    List<Order> getSortedGuestsByName();
    List<Order> ordersSortedByCheckOutDate();
    List<Order> getAllOrderService();
    List<Room> getFreeRoomByFixedDate(LocalDate date);
    List<Maintenance> getGuestServicesSortByPrice(Integer orderId);
    List<Order> getThreeLastGuests(Integer roomId);
}
