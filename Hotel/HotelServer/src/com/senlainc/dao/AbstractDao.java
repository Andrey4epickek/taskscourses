package com.senlainc.dao;

import com.senlainc.api.dao.GenericDao;
import com.senlainc.exceptions.DaoException;
import com.senlainc.model.AEntity;
import com.senlainc.model.Guest;
import com.senlainc.util.SerializationHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    private static final String GET_BY_ID_ERROR_MESSAGE="could not find an entity by id: %d";
    protected final Logger LOGGER=Logger.getLogger(this.getClass().getName());
    private List<T> repository=new ArrayList<>();

    public List<T> getRepository() {
        return repository;
    }

    public void setRepository(List<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T entity) {
        repository.add(entity);
    }

    @Override
    public T getByid(Integer id) {
        for(T entity:repository){
            if(id.equals(entity.getId())){
                return entity;
            }
        }
        LOGGER.log(Level.WARNING,String.format(GET_BY_ID_ERROR_MESSAGE,id));
        throw new DaoException(String.format(GET_BY_ID_ERROR_MESSAGE,id));
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void delete(T entity) {
        repository.remove(entity);
    }

    @Override
    public T update(T entity) {

        return null;
    }

}
