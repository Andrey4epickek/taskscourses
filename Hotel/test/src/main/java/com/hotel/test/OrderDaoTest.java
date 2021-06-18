package com.hotel.test;

import com.hotel.model.Order;
import com.hotel.model.Room;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Test
    public void testSave(){
        Order order = new Order(null,null, LocalDate.of(2021, 6, 18),LocalDate.of(2021, 6, 25));
        entityManager.persist(order);
        assertTrue(order.getId()>0);
    }

    @Test
    public void testGetById() {
        Integer id=1;
        Order order=entityManager.find(Order.class,id);
        assertTrue(order.getCheckInDate()==LocalDate.of(2021, 6, 18));
    }

    @Test
    public void testUpdate(){
        Integer id=1;
        Order order = new Order(null,null, LocalDate.of(2021, 6, 18),LocalDate.of(2021, 6, 23));
        order.setId(id);
        entityManager.merge(order);

        Order updatedOrder=entityManager.find(Order.class,id);
        assertTrue(updatedOrder.getCheckOutDate()==LocalDate.of(2021, 6, 23));
    }

    @Test
    public void testAll(){
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query=builder.createQuery(Order.class);
        Root<Order> root=query.from(Order.class);
        CriteriaQuery<Order> all=query.select(root);

        TypedQuery<Order> allQuery=entityManager.createQuery(all);
        List<Order> guestList=allQuery.getResultList();

        assertFalse(guestList.isEmpty());
    }

    @Test
    public void testDelete(){
        Integer id=1;
        Order order=entityManager.find(Order.class,id);
        entityManager.remove(order);

        Order deletedOrder=entityManager.find(Order.class,id);

        assertNull(deletedOrder);
    }
}
