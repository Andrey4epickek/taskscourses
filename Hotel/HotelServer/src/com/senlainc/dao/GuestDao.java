package com.senlainc.dao;

import com.senlainc.api.dao.IGuestDao;
import com.senlainc.model.Guest;
import com.senlainc.util.SerializationHandler;

import java.util.ArrayList;
import java.util.List;

public class GuestDao extends AbstractDao<Guest> implements IGuestDao {
   public GuestDao() {
        List<Guest> guests= SerializationHandler.deserialize(Guest.class);
        this.saveAll(guests);
    }

    public void saveAll(List<Guest> entity) {
        getRepository().addAll(entity);
    }
}
