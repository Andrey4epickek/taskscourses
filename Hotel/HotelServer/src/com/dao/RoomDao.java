package com.dao;

import com.api.dao.IRoomDao;
import com.model.Room;
import com.util.SerializationHandler;

import java.util.List;


public class RoomDao extends AbstractDao<Room> implements IRoomDao {

    public RoomDao() {
        List<Room> rooms= SerializationHandler.deserialize(Room.class);
       this.saveAll(rooms);
    }

    @Override
    public void saveAll(List<Room> entity) {
        getRepository().addAll(entity);
    }
}
