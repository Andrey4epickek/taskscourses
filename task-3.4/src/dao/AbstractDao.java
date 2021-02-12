package dao;

import api.dao.GenericDao;
import model.AEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    private List<T> repository=new ArrayList<>();

    @Override
    public void save(T entity) {
        repository.add(entity);
    }

    @Override
    public T getByid(Long id) {
        for(T entity:repository){
            if(id.equals(entity.getId())){
                return entity;
            }
        }
        return null;
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
