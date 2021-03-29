package com.dao;

import com.api.dao.IOrderDao;
import com.model.Order;
import com.util.SerializationHandler;

import java.util.List;


public class OrderDao extends AbstractDao<Order> implements IOrderDao {
    private static OrderDao instance;

    public static OrderDao getInstance(){
        if(instance==null){
            instance=new OrderDao();
        }
        return instance;
    }

//    public OrderDao() {
//        List<Order> orders= SerializationHandler.deserialize(Order.class);
//        this.saveAll(orders);
//    }

    @Override
    public void saveAll(List<Order> entity) {
        getRepository().addAll(entity);
    }
}
