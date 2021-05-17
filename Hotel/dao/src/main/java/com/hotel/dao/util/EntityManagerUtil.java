package com.hotel.dao.util;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    @Getter
    private EntityManager entityManager;

    public EntityManagerUtil(){
        init();
    }

    private void init(){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("persistence");
        this.entityManager=factory.createEntityManager();
    }

}
