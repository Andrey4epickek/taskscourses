package api.service;

import model.Guest;

import java.util.List;

public interface IGuestService {
    List<Long> getAllGuestId();
    Guest addGuest(String name, Integer age);
    Guest getGuest(Long guestId);
}
