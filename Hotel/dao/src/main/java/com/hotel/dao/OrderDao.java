package com.hotel.dao;

import com.hotel.api.dao.IOrderDao;
import com.hotel.model.Order;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class OrderDao extends AbstractDao<Order>  implements IOrderDao{
//    private static final String INSERT_QUERY="INSERT INTO orders (checkInDate,checkOutDate) VALUES (?,?);";
//    private static final String UPDATE_QUERY="UPDATE orders SET price=?";
//    private static final String TABLE_NAME="orders";

//    public OrderDao() {
//        List<Order> orders= SerializationHandler.deserialize(Order.class);
//        this.saveAll(orders);
//    }

        public  OrderDao(){

        }
        public OrderDao(EntityManager entityManager) {
            this.entityManager=entityManager;
        }

        @Override
        protected Class<Order> getClazz() {
            return Order.class;
        }

//    @Override
//    public void saveAll(List<Order> entity) {
//        getRepository().addAll(entity);
//    }
//
//    @Override
//    protected String getInsertQuery() {
//        return INSERT_QUERY;
//    }
//
//    @Override
//    protected String getUpdateQuery() {
//        return UPDATE_QUERY;
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, Order entity) throws SQLException {
//        statement.setDate(1,java.sql.Date.valueOf(entity.getCheckInDate()));
//        statement.setDate(2,java.sql.Date.valueOf(entity.getCheckOutDate()));
//    }
//
//
//    @Override
//    protected void prepareStatementForCreate(PreparedStatement statement, Order entity) throws SQLException {
//        statement.setDate(1,java.sql.Date.valueOf(entity.getCheckInDate()));
//        statement.setDate(2,java.sql.Date.valueOf(entity.getCheckOutDate()));
//    }
//
//    @Override
//    protected String getTableName() {
//        return TABLE_NAME;
//    }
}
