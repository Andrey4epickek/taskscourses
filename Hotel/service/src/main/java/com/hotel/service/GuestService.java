package com.hotel.service;


import com.hotel.api.dao.IGuestDao;
import com.hotel.api.service.IGuestService;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Guest;

import com.hotel.model.Room;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Transactional
public class GuestService implements IGuestService {

    private static final Logger LOGGER= LogManager.getLogger(GuestService.class.getName());


    private final IGuestDao guestDao;

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
            guestDao.save(guest);
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
        Guest guest=guestDao.getByid(guestId);
       guestDao.delete(guest);
    }

}
