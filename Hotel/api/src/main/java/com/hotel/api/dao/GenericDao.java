package com.hotel.api.dao;

import com.hotel.model.AEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericDao<T extends AEntity>{

    void save (T entity);
    T getByid(Integer id);
    List<T> getAll();
    void delete(T entity);
    T getByLogin(String login);
    //    void saveAll(List<T> entity);
    void update(T entity);
}
