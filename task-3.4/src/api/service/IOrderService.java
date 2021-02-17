package api.service;

import model.Guest;
import model.Maintenance;
import model.Order;
import model.Room;
import org.w3c.dom.html.HTMLIsIndexElement;


import javax.management.OperationsException;
import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order create(Room room, Guest guest, LocalDate checkInDate,LocalDate checkOutDate);
    void evict(Long guestId,Long orderId,Long roomId);
    void checkIn(Long guestId, Long roomId);
    void countCost(Long orderId);
    void addService( Maintenance maintenance,Long orderId);
    Order getOrder(Long orderId);
    List<Order> getSortedGuestsByName();
    List<Order> ordersSortedByCheckOutDate();
    int getQuantityGuests();
    List<Order> getAllOrderService();
    List<Guest> getAllGuestService();
    List<Room> getFreeRoomByFixedDate(LocalDate date);
    List<Maintenance> getGuestServicesSortByPrice(Long orderId);
    List<Order> getThreeLastGuests(Long roomId);
    List<Long> getAllOrdersId();
}
