package com.senlainc.dao;

import com.senlainc.api.dao.IRoomDao;
import com.senlainc.model.Guest;
import com.senlainc.model.Room;
import com.senlainc.util.SerializationHandler;

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
