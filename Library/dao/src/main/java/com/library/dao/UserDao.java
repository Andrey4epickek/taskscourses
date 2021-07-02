package com.library.dao;

import com.hotel.api.dao.IUserDao;
import com.library.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Repository
public class UserDao  extends AbstractDao<User> implements IUserDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Override
    public User findByUsername(String name) {
        return entityManager.find(User.class,name);
    }

    @Override
    protected Class<User> getClazz() {
        return User.class;
    }
}
