package com.hotel.dao;

import com.hotel.api.dao.GenericDao;
import com.hotel.model.AEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;


public abstract class AbstractDao<T extends AEntity> implements GenericDao<T>{

    private static final String GET_BY_ID_ERROR_MESSAGE="could not find an entity by id: %d";
    protected final Logger LOGGER= LogManager.getLogger(this.getClass().getName());

    protected EntityManager entityManager;

    public void save (T entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
       entityManager.getTransaction().commit();
    }

    public T getByid(Integer id){
        return entityManager.find(getClazz(),id);
    }

    public List<T> getAll(){
//        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
//        CriteriaQuery<T> query=builder.createQuery(getClazz());
//        return entityManager.createQuery(query).getResultList();
       return entityManager.createQuery("Select g from Guest g",getClazz()).getResultList();
    }

    public void   update(T entity){
        entityManager.merge(entity);
    }

    public void delete(Integer Id){
        T entity=getByid(Id);
        entityManager.remove(entity);
    }


    protected abstract Class<T> getClazz();
//
}
