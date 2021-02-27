package api.service;

import model.Room;
import model.RoomStatus;

import java.util.List;

public interface IRoomService {

    Room addRoom(Integer number, Integer capacity, Integer price,Integer stars, RoomStatus status);
    void changeStatus(RoomStatus status,Integer roomId);
    void changePrice(Integer roomId,Integer price);
    List<Room> getSortRoomByPrice();
    List<Room> getSortRoomByCapacity();
    List<Room> getSortRoomByStars();
    List<Integer> getAllRoomsId();
    Room getById(Integer roomId);
}
