package com.service;


import com.api.dao.IGuestDao;
import com.api.service.IGuestService;
import com.config.CustomLogger;
import com.dao.GuestDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceException;
import com.model.Guest;
import com.util.IDGenerator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GuestService implements IGuestService {

    private static final Logger LOGGER=Logger.getLogger(CustomLogger.class.getName());
    private IGuestDao guestDao;

    public GuestService(IGuestDao guestDao){
        this.guestDao=guestDao;
    }


    @Override
    public int getQuantityGuests() {
        List<Guest> guests=getAllGuestService().stream().collect(Collectors.toList());
        return guests.size();
    }

    @Override
    public List<Guest> getAllGuestService() {
        return guestDao.getAll();
    }

    @Override
        public Guest addGuest(String name, Integer age){
            Guest guest=new Guest(name,age);
            guest.setId(IDGenerator.generateGuestId());
            guestDao.save(guest);
            return guest;
    }

    @Override
    public Guest getGuest(Integer guestId) {
        try {
            LOGGER.log(Level.INFO,String.format("getting guest %d",guestId));
            return guestDao.getByid(guestId);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Getting guest failed",e);
            throw new ServiceException("Getting guest failed",e);
        }
    }

    @Override
    public void deleteGuest(Integer guestId) {
       guestDao.delete(guestId);
    }

}
