package com.hotel.api.dao;

import com.hotel.model.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity>{

    void save (T entity);
    T getByid(Integer id);
    List<T> getAll();
    void delete(Integer Id);
//    void saveAll(List<T> entity);
    void update(T entity);
}
