package com.hotel.test;

import com.hotel.model.Guest;
import com.hotel.model.Room;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.*;

public class RoomDaoTest {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Test
    public void testSave(){
        Room room = new Room(1,3,35,4,null);
        entityManager.persist(room);
        assertTrue(room.getId()>0);
    }

    @Test
    public void testGetById() {
        Integer id=1;
        Room room=entityManager.find(Room.class,id);
        assertTrue(room.getPrice()==35);
    }

    @Test
    public void testUpdate(){
        Integer id=1;
        Room room = new Room(1,3,40,4,null);
        room.setId(id);
        entityManager.merge(room);

        Room updatedRoom=entityManager.find(Room.class,id);
        assertTrue(updatedRoom.getPrice()==40);
    }

    @Test
    public void testAll(){
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Room> query=builder.createQuery(Room.class);
        Root<Room> root=query.from(Room.class);
        CriteriaQuery<Room> all=query.select(root);

        TypedQuery<Room> allQuery=entityManager.createQuery(all);
        List<Room> guestList=allQuery.getResultList();

        assertFalse(guestList.isEmpty());
    }

    @Test
    public void testDelete(){
        Integer id=1;
        Room room=entityManager.find(Room.class,id);
        entityManager.remove(room);

        Room deletedRoom=entityManager.find(Room.class,id);

        assertNull(deletedRoom);
    }

}
