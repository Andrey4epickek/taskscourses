package com.senlainc.dao;

import com.senlainc.api.dao.IOrderDao;
import com.senlainc.model.Order;
import com.senlainc.model.Room;
import com.senlainc.util.SerializationHandler;

import java.util.List;


public class OrderDao extends AbstractDao<Order> implements IOrderDao {
    private static OrderDao instance;

    public static OrderDao getInstance(){
        if(instance==null){
            instance=new OrderDao();
        }
        return instance;
    }

    public OrderDao() {
        List<Order> orders= SerializationHandler.deserialize(Order.class);
        this.saveAll(orders);
    }

    @Override
    public void saveAll(List<Order> entity) {
        getRepository().addAll(entity);
    }
}
