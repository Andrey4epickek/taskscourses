package com.hotel.api.service;

import com.hotel.model.Guest;
import com.hotel.model.Room;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String name, Integer age, Room room);
    Guest getGuest(Integer guestId);
    void deleteGuest(Integer guestId);
    int getQuantityGuests();
    List<Guest> getAllGuestService();
}
