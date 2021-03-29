package com.api.service;

import com.model.Guest;

public interface IGuestService {

    Guest addGuest(String name, Integer age);
    Guest getGuest(Integer guestId);
}
