package com.hotel.api.service;

import com.hotel.model.Guest;
import com.hotel.model.Room;
import com.hotel.model.dto.GuestDto;
import com.hotel.model.dto.RoomDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String name, Integer age, RoomDto roomDto);
    GuestDto getById(Integer guestId);
    List<GuestDto> getAll();
    void deleteGuest(Integer guestId);
}
