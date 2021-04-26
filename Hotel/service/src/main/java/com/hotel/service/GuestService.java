package com.hotel.service;


import com.hotel.api.dao.IGuestDao;
import com.hotel.api.service.IGuestService;
import com.hotel.config.CustomLogger;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Guest;
import com.hotel.IDGenerator;

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
