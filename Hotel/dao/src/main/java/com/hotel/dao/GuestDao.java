package com.hotel.dao;

import com.hotel.api.dao.IGuestDao;
import com.hotel.model.Guest;
import org.springframework.stereotype.Repository;



@Repository
public class GuestDao extends AbstractDao<Guest> implements IGuestDao{


    @Override
    protected Class<Guest> getClazz() {
        return Guest.class;
    }


}