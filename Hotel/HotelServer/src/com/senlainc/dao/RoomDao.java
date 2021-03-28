package com.senlainc.dao;

import com.senlainc.api.dao.IRoomDao;
import com.senlainc.model.Room;
import com.senlainc.util.SerializationHandler;

import java.util.List;


public class RoomDao extends AbstractDao<Room> implements IRoomDao {
    private static RoomDao instance;

    public static RoomDao getInstance(){
        if(instance==null){
            instance=new RoomDao();
        }
        return instance;
    }

    public RoomDao() {
        List<Room> rooms= SerializationHandler.deserialize(Room.class);
       this.saveAll(rooms);
    }



    @Override
    public void saveAll(List<Room> entity) {
        getRepository().addAll(entity);
    }
}
