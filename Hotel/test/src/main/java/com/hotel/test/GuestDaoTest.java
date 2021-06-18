package com.hotel.test;

import com.hotel.model.Guest;
import org.junit.Test;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class GuestDaoTest {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Test
    public void testSave(){
        Guest guest = new Guest("andrey", 10,null);
        entityManager.persist(guest);
        assertTrue(guest.getId()>0);
    }

    @Test
    public void testGetById() {
        Integer id=1;
        Guest guest=entityManager.find(Guest.class,id);
        assertEquals("andrey",guest.getName());
    }

    @Test
    public void testUpdate(){
        Integer id=1;
        Guest guest=new Guest("andrey",20,null);
        guest.setId(id);
        entityManager.merge(guest);

        Guest updatedGuest=entityManager.find(Guest.class,id);
        assertEquals("andrey",updatedGuest.getName());
    }

    @Test
    public void testAll(){
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Guest> query=builder.createQuery(Guest.class);
        Root<Guest> root=query.from(Guest.class);
        CriteriaQuery<Guest> all=query.select(root);

        TypedQuery<Guest> allQuery=entityManager.createQuery(all);
        List<Guest> guestList=allQuery.getResultList();

        assertFalse(guestList.isEmpty());
    }

    @Test
    public void testDelete(){
        Integer id=1;
        Guest guest=entityManager.find(Guest.class,id);
        entityManager.remove(guest);

        Guest deletedGuest=entityManager.find(Guest.class,id);

        assertNull(deletedGuest);
    }

}
