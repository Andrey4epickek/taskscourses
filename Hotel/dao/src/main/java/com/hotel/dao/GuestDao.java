package com.hotel.dao;

import com.hotel.api.dao.IGuestDao;
import com.hotel.model.Guest;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GuestDao extends AbstractDao<Guest> implements IGuestDao{


    public GuestDao(){

    }
    public GuestDao(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    protected Class<Guest> getClazz() {
        return Guest.class;
    }


}
