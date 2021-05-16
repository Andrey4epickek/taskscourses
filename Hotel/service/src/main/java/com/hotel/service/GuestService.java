package com.hotel.service;


import com.hotel.api.dao.IGuestDao;
import com.hotel.api.service.IGuestService;
import com.hotel.config.CustomLogger;
import com.hotel.config.EntityManagerUtil;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Guest;
import com.hotel.IDGenerator;
import com.hotel.model.Room;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService implements IGuestService {

    private static final Logger LOGGER= LogManager.getLogger(GuestService.class.getName());
    private static final EntityManagerUtil emu=new EntityManagerUtil();

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
        public Guest addGuest(String name, Integer age, Room room){
            Guest guest=new Guest();
            guest.setName(name);
            guest.setAge(age);
            guest.setRoom(room);
            emu.beginTransaction();
            guestDao.save(guest);
            emu.commit();
            return guest;
    }

    @Override
    public Guest getGuest(Integer guestId) {
        try {
            LOGGER.info(String.format("getting guest %d",guestId));
            return guestDao.getByid(guestId);
        }catch (DaoException e){
            LOGGER.warn("Getting guest failed",e);
            throw new ServiceException("Getting guest failed",e);
        }
    }

    @Override
    public void deleteGuest(Integer guestId) {
       guestDao.delete(guestId);
    }

}
