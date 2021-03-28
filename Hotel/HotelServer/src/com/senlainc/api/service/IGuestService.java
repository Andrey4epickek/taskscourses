package com.senlainc.api.service;

import com.senlainc.model.Guest;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String name, Integer age);
    Guest getGuest(Integer guestId);
}
