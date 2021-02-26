package api.dao;

import model.AEntity;

import java.util.List;

public interface GenericDao <T extends AEntity>{

    void save (T entity);
    T getByid(Integer id);
    List<T> getAll();
    void delete(T entity);
    T update(T entiy);
}
