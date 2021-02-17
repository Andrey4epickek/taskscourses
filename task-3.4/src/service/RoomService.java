package service;

import api.dao.IGuestDao;
import api.dao.IRoomDao;
import api.service.IRoomService;
import model.Guest;
import model.Room;
import model.RoomStatus;
import util.IDGenerator;

import java.util.List;
import java.util.stream.Collectors;


public class RoomService implements IRoomService {
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;

    public RoomService(IRoomDao roomDao, IGuestDao guestDao) {
        this.roomDao = roomDao;
        this.guestDao = guestDao;
    }

    @Override
    public void changeStatus(RoomStatus status,Long roomId) {
        Room room=roomDao.getByid(roomId);
        room.setStatus(status);
    }

    @Override
    public void changePrice(Long roomId, Integer price) {
        Room room=roomDao.getByid(roomId);
        room.setPrice(price);
    }

    @Override
    public List<Room> getSortRoomByPrice() {
        List<Room> rooms=roomDao.getAll();
        rooms.sort(((o1,o2)->o1.getPrice()- o2.getPrice()));
        return rooms;
    }

    @Override
    public List<Room> getSortRoomByCapacity() {
        List<Room> rooms=roomDao.getAll();
        rooms.sort(((o1, o2) -> o1.getCapacity()- o2.getCapacity()));
        return rooms;
    }

    @Override
    public List<Room> getSortRoomByStars() {
        List<Room> rooms=roomDao.getAll();
        rooms.sort(((o1, o2) -> o1.getStars()- o2.getStars()));
        return rooms;
    }

    @Override
    public List<Long> getAllRoomsId() {
        return roomDao.getAll().stream().map(Room::getId).collect(Collectors.toList());
    }

    @Override
    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars, RoomStatus status) {
        Room room =new Room(number,capacity,price,status,stars,guestDao.getAll());
        room.setId(IDGenerator.generateRoomId());
        roomDao.save(room);
        return room;
    }

}
