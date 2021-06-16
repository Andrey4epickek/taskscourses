package com.hotel.service;

import com.hotel.api.dao.IUserDao;
import com.hotel.api.service.IUserService;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {

    private static final Logger LOGGER= LogManager.getLogger(UserService.class.getName());

    private final IUserDao userDao;

    @Override
    public User addUser(String login, String password, String role) {
        try {
            LOGGER.info(String.format("Adding of user"));
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            userDao.save(user);
            return user;
        }catch (DaoException e){
            LOGGER.warn("Adding of user failed",e);
            throw new ServiceException("Adding of user failed",e);
        }
    }

    @Override
    public User getByLogin(String login) {
        try {
            LOGGER.info(String.format("getting user %s",login));
            User user=userDao.getByLogin(login);
            return user;
        }catch (DaoException e){
            LOGGER.warn("Getting user failed",e);
            throw new ServiceException("Getting user failed",e);
        }
    }

    @Override
    public User getById(Integer id) {
        try {
            LOGGER.info(String.format("getting user %d",id));
            User user=userDao.getByid(id);
            return user;
        }catch (DaoException e){
            LOGGER.warn("Getting user failed",e);
            throw new ServiceException("Getting user failed",e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            LOGGER.info(String.format("getting user %s",username));
            User user=userDao.getByLogin(username);
            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            return user;
        }catch (DaoException e){
            LOGGER.warn("Getting user failed",e);
            throw new ServiceException("Getting user failed",e);
        }
    }
}
