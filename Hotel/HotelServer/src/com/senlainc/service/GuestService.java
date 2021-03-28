package com.senlainc.service;


import com.senlainc.api.service.IGuestService;
import com.senlainc.config.CustomLogger;
import com.senlainc.dao.GuestDao;
import com.senlainc.exceptions.DaoException;
import com.senlainc.exceptions.ServiceException;
import com.senlainc.model.Guest;
import com.senlainc.util.IDGenerator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GuestService implements IGuestService {
    private static GuestService instance;
    private static final Logger LOGGER=Logger.getLogger(CustomLogger.class.getName());

    public static GuestService getInstance(){
        if(instance==null){
            instance=new GuestService();
        }
        return instance;
    }

    @Override
        public Guest addGuest(String name, Integer age){
            Guest guest=new Guest(name,age);
            guest.setId(IDGenerator.generateGuestId());
            GuestDao.getInstance().save(guest);
            return guest;
    }

    @Override
    public Guest getGuest(Integer guestId) {
        try {
            LOGGER.log(Level.INFO,String.format("getting guest %d",guestId));
            return GuestDao.getInstance().getByid(guestId);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Getting guest failed",e);
            throw new ServiceException("Getting guest failed",e);
        }
    }

}
