package com.hotel.dao;

import com.hotel.api.dao.IOrderDao;
import com.hotel.model.Order;
import org.springframework.stereotype.Repository;




@Repository
public class OrderDao extends AbstractDao<Order>  implements IOrderDao{



        @Override
        protected Class<Order> getClazz() {
            return Order.class;
        }

}
