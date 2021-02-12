package service;

import api.dao.IGuestDao;
import api.dao.IRoomDao;
import api.service.IRoomService;
import model.Guest;
import model.Room;
import model.RoomStatus;
import util.IDGenerator;


public class RoomService implements IRoomService {
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;

    public RoomService(IRoomDao roomDao, IGuestDao guestDao) {
        this.roomDao = roomDao;
        this.guestDao = guestDao;
    }

    @Override
    public void evictGuest(Long guestId,Long roomId){
        Room room=roomDao.getByid(roomId);
        Guest guest=guestDao.getByid(guestId);
        room.getGuests().remove(guest);
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
    public void checkIn(Long guestId, Long roomId) {
        Room room=roomDao.getByid(roomId);
        Guest guest=guestDao.getByid(guestId);
        room.getGuests().add(guest);
    }

    @Override
    public Room addRoom(Integer number, Integer capacity, Integer price, RoomStatus status) {
        Room room =new Room(number,capacity,price,status,guestDao.getAll());
        room.setId(IDGenerator.generateRoomId());
        roomDao.save(room);
        return room;
    }



}
