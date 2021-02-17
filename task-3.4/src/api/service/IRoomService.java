package api.service;

import model.Room;
import model.RoomStatus;

import java.util.List;

public interface IRoomService {

    Room addRoom(Integer number, Integer capacity, Integer price,Integer stars, RoomStatus status);
    void changeStatus(RoomStatus status,Long roomId);
    void changePrice(Long roomId,Integer price);
    List<Room> getSortRoomByPrice();
    List<Room> getSortRoomByCapacity();
    List<Room> getSortRoomByStars();
    List<Long> getAllRoomsId();
}
