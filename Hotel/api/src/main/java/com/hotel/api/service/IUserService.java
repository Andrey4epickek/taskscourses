package com.hotel.api.service;

import com.hotel.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User addUser(String login, String password, String role);
    User getByLogin(String login);
    User getById(Integer id);
}
