package com.hotel.service;

import com.hotel.api.dao.IRoomDao;
import com.hotel.api.service.IRoomService;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService implements IRoomService {

    private static final Logger LOGGER= LogManager.getLogger(RoomService.class.getName());

    private final IRoomDao roomDao;
    private final ModelMapper mapper;

    @Override
    public void changeStatus(RoomStatus status,Integer roomId) {
//        try {
//                LOGGER.info(String.format("changeStatus of room %d", roomId));
//                Room room = roomDao.getByid(roomId);
//                room.setStatus(status);
//            roomDao.update(room);
//        }catch (DaoException e){
//            LOGGER.warn("Change status failed",e);
//            throw new ServiceException("Change status failed",e);
//        }
    }

    @Override
    public void changePrice(Integer roomId, Integer price) {
        try {
            LOGGER.info(String.format("changePrice of room %d with price %d",roomId,price));
        Room room=roomDao.getByid(roomId);
        room.setPrice(price);
        roomDao.update(room);
        }catch (DaoException e){
            LOGGER.warn("Change price failed",e);
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
    public Room getRoom(Integer roomId) {
        try {
            LOGGER.info(String.format("getting room %d",roomId));
            return roomDao.getByid(roomId);
        }catch (DaoException e){
            LOGGER.warn("Getting room failed",e);
            throw new ServiceException("Getting room failed",e);
        }
    }

    @Override
    public RoomDto getById(Integer roomId) {
        Room room=roomDao.getByid(roomId);
        return mapper.map(room,RoomDto.class);
    }

    @Override
    public Room addRoom(Integer number, Integer capacity, Integer price,Integer stars, RoomStatus status) {
        try {
            LOGGER.info(String.format("Adding of room %d with capacity %d, price %d, stars %d",number,capacity,price,stars));
        Room room =new Room();
        room.setNumber(number);
        room.setCapacity(capacity);
        room.setPrice(price);
        room.setStars(stars);

            roomDao.save(room);

        return room;
    }catch (DaoException e){
        LOGGER.warn("Adding of room failed",e);
        throw new ServiceException("Adding of room failed",e);
    }
    }

}
