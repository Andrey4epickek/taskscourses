package com.api.dao;

import com.model.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity>{

    void save (T entity);
    T getByid(Integer id);
    List<T> getByIdList(Integer id);
    List<T> getAll();
    void delete(T entity);
    void saveAll(List<T> entity);
}
