package com.hotel.test;

import com.hotel.model.Guest;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import static org.junit.Assert.assertEquals;

public class GuestDaoTest {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Test
    public void testSave(){
        Guest guest = new Guest("Andrey", 10,null);
        entityManager.persist(guest);
        assertEquals("andrey",guest.getName());
    }

    @Test
    public void testGetById() {
        Integer id=1;
        Guest guest=entityManager.find(Guest.class,id);
        assertEquals("andrey",guest.getName());
    }



}
