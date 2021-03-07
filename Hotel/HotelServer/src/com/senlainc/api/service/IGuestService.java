package com.senlainc.api.service;

import com.senlainc.model.Guest;

import java.util.List;

public interface IGuestService {
    List<Integer> getAllGuestId();
    Guest addGuest(String name, Integer age);
    Guest getGuest(Integer guestId);
}
