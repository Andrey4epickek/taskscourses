package dao;

import api.dao.GenericDao;
import exceptions.DaoException;
import model.AEntity;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    private static final String GET_BY_ID_ERROR_MESSAGE="could not find an entity by id: %d";
    protected final Logger LOGGER=Logger.getLogger(this.getClass().getName());
    private List<T> repository=new ArrayList<>();

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
