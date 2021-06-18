package com.hotel.test;

import com.hotel.model.Guest;
import com.hotel.model.Maintenance;
import org.jboss.jandex.Main;
import org.junit.Test;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.Assert.*;

public class MaintenanceDaoTest {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Test
    public void testSave(){
        Maintenance maintenance = new Maintenance("lunch", 10,null);
        entityManager.persist(maintenance);
        assertTrue(maintenance.getId()>0);
    }

    @Test
    public void testGetById() {
        Integer id=1;
        Maintenance maintenance=entityManager.find(Maintenance.class,id);
        assertEquals("lunch",maintenance.getName());
    }

    @Test
    public void testUpdate(){
        Integer id=1;
        Maintenance maintenance=new Maintenance("lunch",15,null);
        maintenance.setId(id);
        entityManager.merge(maintenance);

        Maintenance updatedMaintenance=entityManager.find(Maintenance.class,id);
        assertTrue(updatedMaintenance.getPrice()==15);
    }

    @Test
    public void testAll(){
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Maintenance> query=builder.createQuery(Maintenance.class);
        Root<Maintenance> root=query.from(Maintenance.class);
        CriteriaQuery<Maintenance> all=query.select(root);

        TypedQuery<Maintenance> allQuery=entityManager.createQuery(all);
        List<Maintenance> guestList=allQuery.getResultList();

        assertFalse(guestList.isEmpty());
    }

    @Test
    public void testDelete(){
        Integer id=1;
        Maintenance maintenance=entityManager.find(Maintenance.class,id);
        entityManager.remove(maintenance);

        Maintenance deletedMaintenance=entityManager.find(Maintenance.class,id);

        assertNull(deletedMaintenance);
    }

}
