package com.hotel.dao;


import com.hotel.api.dao.IUserDao;

import com.hotel.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User> implements IUserDao {
    @Override
    protected Class<User> getClazz() {
        return User.class;
    }
}
