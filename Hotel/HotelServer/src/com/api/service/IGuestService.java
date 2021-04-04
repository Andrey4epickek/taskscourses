package com.api.service;

import com.model.Guest;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String name, Integer age);
    Guest getGuest(Integer guestId);
    int getQuantityGuests();
    List<Guest> getAllGuestService();
}
