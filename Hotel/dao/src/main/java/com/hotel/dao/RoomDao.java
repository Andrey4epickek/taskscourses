package com.hotel.dao;

import com.hotel.api.dao.IRoomDao;
import com.hotel.model.Room;
import org.springframework.stereotype.Repository;



@Repository
public class RoomDao extends AbstractDao<Room> implements IRoomDao{


    @Override
    protected Class<Room> getClazz() {
        return Room.class;
    }


}