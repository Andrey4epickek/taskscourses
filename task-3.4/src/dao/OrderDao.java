package dao;

import api.dao.IOrderDao;
import model.Order;

import java.time.Duration;
import java.time.LocalDate;


public class OrderDao extends AbstractDao<Order> implements IOrderDao {
    public long getDaysBetweenDats(LocalDate checkInDate,LocalDate checkOutDate){
        long daysBetween = Duration.between(checkInDate, checkOutDate).toDays();
        return daysBetween;
    }
}
