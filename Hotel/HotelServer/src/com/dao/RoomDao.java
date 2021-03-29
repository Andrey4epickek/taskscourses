package com.dao;

import com.api.dao.IRoomDao;
import com.model.Room;
import com.util.SerializationHandler;

import java.util.List;


public class RoomDao extends AbstractDao<Room> implements IRoomDao {
    private static RoomDao instance;

    public static RoomDao getInstance(){
        if(instance==null){
            instance=new RoomDao();
        }
        return instance;
    }

//    public RoomDao() {
//        List<Room> rooms= SerializationHandler.deserialize(Room.class);
//       this.saveAll(rooms);
//    }



    @Override
    public void saveAll(List<Room> entity) {
        getRepository().addAll(entity);
    }
}
