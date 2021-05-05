package com.api.dao;

import com.model.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity>{

    T save (T entity);
    T getByid(Integer id);
    List<T> getByIdList(Integer id);
    List<T> getAll();
    void delete(Integer Id);
    void saveAll(List<T> entity);
    T update(T entity);
}
