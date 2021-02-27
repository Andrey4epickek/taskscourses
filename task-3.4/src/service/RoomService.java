package service;

import api.dao.IGuestDao;
import api.dao.IRoomDao;
import api.service.IRoomService;
import exceptions.DaoException;
import exceptions.ServiceException;
import model.Room;
import model.RoomStatus;
import util.IDGenerator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class RoomService implements IRoomService {

    private static final Logger LOGGER=Logger.getLogger(RoomService.class.getName());
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;

    public RoomService(IRoomDao roomDao, IGuestDao guestDao) {
        this.roomDao = roomDao;
        this.guestDao = guestDao;
    }

    @Override
    public void changeStatus(RoomStatus status,Integer roomId) {
        try {
            LOGGER.log(Level.INFO,String.format("changeStatus of room %d",roomId));
            Room room = roomDao.getByid(roomId);
            room.setStatus(status);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Change status failed",e);
            throw new ServiceException("Change status failed",e);
        }
    }

    @Override
    public void changePrice(Integer roomId, Integer price) {
        try {
            LOGGER.log(Level.INFO,String.format("changePrice of room %d with price %d",roomId,price));
        Room room=roomDao.getByid(roomId);
        room.setPrice(price);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Change price failed",e);
            throw new ServiceException("Change price failed",e);
        }
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
    public List<Integer> getAllRoomsId() {
        return roomDao.getAll().stream().map(Room::getId).collect(Collectors.toList());
    }

    @Override
    public Room getById(Integer roomId) {
        Room room=roomDao.getByid(roomId);
        return room;
    }

    @Override
    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars, RoomStatus status) {
        try {
            LOGGER.log(Level.INFO,String.format("Adding of room %d with capacity %d, price %d, stars %d",number,capacity,price,stars));
        Room room =new Room(number,capacity,price,status,stars,guestDao.getAll());
        room.setId(IDGenerator.generateRoomId());
        roomDao.save(room);
        return room;
    }catch (DaoException e){
        LOGGER.log(Level.WARNING,"Adding of room failed",e);
        throw new ServiceException("Adding of room failed",e);
    }
    }

}
