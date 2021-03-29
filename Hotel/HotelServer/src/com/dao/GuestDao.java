package com.dao;

import com.api.dao.IGuestDao;
import com.model.Guest;
import com.util.SerializationHandler;

import java.util.List;

public class GuestDao extends AbstractDao<Guest> implements IGuestDao {
    private static GuestDao instance;

    public static GuestDao getInstance(){
        if(instance==null){
            instance=new GuestDao();
        }
        return instance;
    }

//   public GuestDao() {
//        List<Guest> guests= SerializationHandler.deserialize(Guest.class);
//        this.saveAll(guests);
//    }

    public void saveAll(List<Guest> entity) {
        getRepository().addAll(entity);
    }
}
