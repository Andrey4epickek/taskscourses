package com.hotel.dao;

import com.hotel.api.dao.GenericDao;
import com.hotel.model.AEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
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
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query=builder.createQuery(getClazz());
        Root<T>root=query.from(getClazz());
        CriteriaQuery<T> all=query.select(root);

        TypedQuery<T> allQuery=entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public void   update(T entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(T entity){
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }


    protected abstract Class<T> getClazz();
//
}
