package api.service;

import model.Guest;

public interface IGuestService {
    Guest addGuest(String name, Integer age);
}
