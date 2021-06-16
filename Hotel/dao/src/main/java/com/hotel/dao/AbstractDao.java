package com.hotel.dao;

import com.hotel.api.dao.GenericDao;
import com.hotel.model.AEntity;
import org.springframework.data.domain.Pageable;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;


public abstract class AbstractDao<T extends AEntity> implements GenericDao<T>{


    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    public void save (T entity){
        entityManager.persist(entity);
    }

    public T getByid(Integer id){
        return entityManager.find(getClazz(),id);
    }

    public T getByLogin(String login){
        return entityManager.find(getClazz(),login);
    }

    public List<T> getAll(){
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query=builder.createQuery(getClazz());
        Root<T>root=query.from(getClazz());
        CriteriaQuery<T> all=query.select(root);

        TypedQuery<T> allQuery=entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public void update(T entity){
        entityManager.merge(entity);
    }

    public void delete(T entity){
        entityManager.remove(entity);
    }


    protected abstract Class<T> getClazz();
//
}