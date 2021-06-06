package com.hotel.service;


import com.hotel.api.dao.IGuestDao;
import com.hotel.api.dao.IRoomDao;
import com.hotel.api.service.IGuestService;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Guest;

import com.hotel.model.Room;
import com.hotel.model.dto.GuestDto;
import com.hotel.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class GuestService implements IGuestService {

    private static final Logger LOGGER= LogManager.getLogger(GuestService.class.getName());

    private final IGuestDao guestDao;
    private final ModelMapper mapper;

    @Override
    public Guest addGuest(String name, Integer age, RoomDto roomDto){
        try {
            LOGGER.info(String.format("Adding of guest %s with age %d",name,age));
            Guest guest = new Guest();
            guest.setName(name);
            guest.setAge(age);
            Room room=mapper.map(roomDto,Room.class);
            guest.setRoom(room);
            guestDao.save(guest);
            return guest;
        }catch (DaoException e){
            LOGGER.warn("Adding of guest failed",e);
            throw new ServiceException("Adding of guest failed",e);
        }
    }

    @Override
    public GuestDto getById(Integer guestId) {
        try {
            LOGGER.info(String.format("getting guest %d",guestId));
        Guest guest=guestDao.getByid(guestId);
        return mapper.map(guest,GuestDto.class);
        }catch (DaoException e){
            LOGGER.warn("Getting guest failed",e);
            throw new ServiceException("Getting guest failed",e);
        }
    }

    @Override
    public List<GuestDto> getAll() {
        List<Guest> guestList=guestDao.getAll();
        guestList.sort(((o1, o2) -> o1.getAge()- o2.getAge()));
        List<GuestDto> guestDtos=new ArrayList<>();
        for(Guest guest:guestList){
            GuestDto guestDto=mapper.map(guest,GuestDto.class);
            guestDtos.add(guestDto);
        }
        return guestDtos;
    }

    @Override
    public void deleteGuest(Integer guestId) {
        Guest guest=guestDao.getByid(guestId);
        guestDao.delete(guest);
    }

}