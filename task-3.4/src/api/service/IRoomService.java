package api.service;

import model.Room;
import model.RoomStatus;

public interface IRoomService {
    void checkIn(Long guestId, Long roomId);
    Room addRoom(Integer number, Integer capacity, Integer price, RoomStatus status);
    void evictGuest(Long guestId,Long roomId);
    void changeStatus(RoomStatus status,Long roomId);
    void changePrice(Long roomId,Integer price);
}
