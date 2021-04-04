package com.service;
import com.api.service.IRoomService;
import com.config.CustomLogger;
import com.dao.GuestDao;

import com.dao.RoomDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceException;
import com.model.Room;
import com.model.RoomStatus;
import com.util.IDGenerator;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class RoomService implements IRoomService {

    private static final Logger LOGGER=Logger.getLogger(CustomLogger.class.getName());
    private static RoomService instance;

    public static RoomService getInstance(){
        if(instance==null){
            instance=new RoomService();
        }
        return instance;
    }

    @Override
    public void changeStatus(RoomStatus status,Integer roomId) {
        try {
                LOGGER.log(Level.INFO, String.format("changeStatus of room %d", roomId));
                Room room = RoomDao.getInstance().getByid(roomId);
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
        Room room=RoomDao.getInstance().getByid(roomId);
        room.setPrice(price);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Change price failed",e);
            throw new ServiceException("Change price failed",e);
        }
    }

    @Override
    public List<Room> getSortRoomByPrice() {

        List<Room> rooms=RoomDao.getInstance().getAll();
        rooms.sort(((o1,o2)->o1.getPrice()- o2.getPrice()));
        return rooms;
    }

    @Override
    public List<Room> getSortRoomByCapacity() {

        List<Room> rooms=RoomDao.getInstance().getAll();
        rooms.sort(((o1, o2) -> o1.getCapacity()- o2.getCapacity()));
        return rooms;

    }

    @Override
    public List<Room> getSortRoomByStars() {

        List<Room> rooms=RoomDao.getInstance().getAll();
        rooms.sort(((o1, o2) -> o1.getStars()- o2.getStars()));
        return rooms;

    }

    @Override
    public Room getRoom(Integer roomId) {
        try {
            LOGGER.log(Level.INFO,String.format("getting room %d",roomId));
            return RoomDao.getInstance().getByid(roomId);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Getting room failed",e);
            throw new ServiceException("Getting room failed",e);
        }
    }

    @Override
    public Room getById(Integer roomId) {
        Room room=RoomDao.getInstance().getByid(roomId);
        return room;
    }

    @Override
    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars, RoomStatus status,Integer guestId) {
        try {
            LOGGER.log(Level.INFO,String.format("Adding of room %d with capacity %d, price %d, stars %d",number,capacity,price,stars));
        Room room =new Room(number,capacity,price,status,stars, GuestDao.getInstance().getByIdList(guestId));
        room.setId(IDGenerator.generateRoomId());
        RoomDao.getInstance().save(room);
        return room;
    }catch (DaoException e){
        LOGGER.log(Level.WARNING,"Adding of room failed",e);
        throw new ServiceException("Adding of room failed",e);
    }
    }

}
