package com.hotel.api.service;

import com.hotel.model.Guest;
import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.Room;
import com.hotel.model.dto.GuestDto;
import com.hotel.model.dto.OrderDto;
import com.hotel.model.dto.RoomDto;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order create(RoomDto room, GuestDto guest, LocalDate checkInDate, LocalDate checkOutDate);
    void evict(Integer guestId,Integer orderId,Integer roomId);
    void checkIn(Integer guestId, Integer roomId);
    int countCost(Integer orderId);
    void addService( Integer maintenanceId,Integer orderId);
    Order getOrder(Integer orderId);
    OrderDto getById(Integer orderId);
    List<Order> getSortedGuestsByName();
    List<Order> ordersSortedByCheckOutDate();
    List<Order> getAllOrderService();
    List<Room> getFreeRoomByFixedDate(LocalDate date);
    List<Maintenance> getGuestServicesSortByPrice(Integer orderId);
    List<Order> getThreeLastGuests(Integer roomId);
}
