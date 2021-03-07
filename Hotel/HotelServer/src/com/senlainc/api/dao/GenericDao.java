package com.senlainc.api.dao;

import com.senlainc.model.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity>{

    void save (T entity);
    T getByid(Integer id);
    List<T> getAll();
    void delete(T entity);
    T update(T entiy);
}
