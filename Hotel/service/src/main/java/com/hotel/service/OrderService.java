package com.hotel.service;

import com.hotel.api.dao.IGuestDao;
import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.api.dao.IOrderDao;
import com.hotel.api.dao.IRoomDao;
import com.hotel.api.service.IOrderService;

import com.hotel.comparators.GuestNameComparator;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Guest;
import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.Room;
import com.hotel.IDGenerator;
import com.hotel.comparators.OrderCheckOutDateComparator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class OrderService implements IOrderService {

    private static final Logger LOGGER= LogManager.getLogger(OrderService.class.getName());
    private IOrderDao orderDao;
    private IMaintenanceDao maintenanceDao;
    private IRoomDao roomDao;
    private IGuestDao guestDao;

    public OrderService(IOrderDao orderDao, IMaintenanceDao maintenanceDao,IRoomDao roomDao,IGuestDao guestDao){
        this.orderDao=orderDao;
        this.maintenanceDao=maintenanceDao;
        this.roomDao=roomDao;
        this.guestDao=guestDao;
    }
    @Override
    public Order create(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        try {
            LOGGER.info(String.format("Creating of order"));
        Order order=new Order(room,guest,checkInDate,checkOutDate);
        orderDao.save(order);
        return order;
        }catch (DaoException e){
            LOGGER.warn("Creating failed",e);
            throw new ServiceException("Creating failed",e);
        }
    }

    @Override
    public void evict(Integer guestId, Integer orderId,Integer roomId) {
        try {
            LOGGER.info(String.format("Eviction of a guest %d, order %d, room %d",guestId,orderId,roomId));
        Room room= roomDao.getByid(roomId);
        Guest guest= guestDao.getByid(guestId);
        room.getGuests().remove(guest);
        }catch (DaoException e){
            LOGGER.warn("Eviction failed",e);
            throw new ServiceException("Eviction failed",e);
        }
    }

    @Override
    public void checkIn(Integer guestId,Integer roomId) {
        try {
            LOGGER.info(String.format("checkIn  guest %d to room number %d",guestId,roomId));
        Room room=roomDao.getByid(roomId);
        Guest guest=guestDao.getByid(guestId);
        room.getGuests().add(guest);
        }catch (DaoException e){
            LOGGER.warn("CheckIn failed",e);
            throw new ServiceException("CheckIn failed",e);
        }
    }

    @Override
    public int countCost(Integer orderId) {
        try {
            LOGGER.info(String.format("count cost for order %d",orderId));
        Order costCountOrder=orderDao.getByid(orderId);
        int cost=0;
        for(Maintenance maintenance:costCountOrder.getMaintenances()){
            cost=cost+getDaysBetweenDates(costCountOrder.getCheckInDate(),costCountOrder.getCheckOutDate())*maintenance.getPrice();
        }
        costCountOrder.setCost(cost);
        return cost;
    }catch (DaoException e){
        LOGGER.warn("counting failed",e);
        throw new ServiceException("counting failed",e);
    }
    }

    @Override
    public void addService(Integer maintenanceId,Integer orderId) {
        try {
            LOGGER.info(String.format("adding service for order %d",orderId));
            Order order=orderDao.getByid(orderId);
            Maintenance maintenance=maintenanceDao.getByid(maintenanceId);
            order.getMaintenances().add(maintenance);
        }catch (DaoException e){
            LOGGER.warn("Adding service failed",e);
            throw new ServiceException("Adding service failed",e);
        }
    }

    @Override
    public Order getOrder(Integer orderId) {
        try {
            LOGGER.info(String.format("getting order %d",orderId));
        return orderDao.getByid(orderId);
        }catch (DaoException e){
            LOGGER.warn("Getting order failed",e);
            throw new ServiceException("Getting order failed",e);
        }
    }

    @Override
    public List<Order> getSortedGuestsByName() {
        List<Order> orderList=getAllOrderService();
        orderList.sort(new GuestNameComparator());
        return orderList.stream().collect(Collectors.toList());
    }

    @Override
    public List<Order> ordersSortedByCheckOutDate() {
        List<Order> orders=orderDao.getAll();
        orders.sort(new OrderCheckOutDateComparator());
        return orders.stream().collect(Collectors.toList());
    }



    @Override
    public List<Order> getAllOrderService() {
        return orderDao.getAll();
    }



    @Override
    public List<Room> getFreeRoomByFixedDate(LocalDate date) {
        List<Order>orders=orderDao.getAll();
        return orders.stream().filter(o1->o1.getCheckOutDate().isBefore(date)).map(Order::getRoom).collect(Collectors.toList());
    }

    @Override
    public List<Maintenance> getGuestServicesSortByPrice(Integer orderId) {
        try {
            LOGGER.info(String.format("sorting guest services for order %d",orderId));
        List<Maintenance> maintenances=getOrder(orderId).getMaintenances();
        maintenances.sort((s1,s2)->s1.getPrice()-s2.getPrice());
        return maintenances;
        }catch (DaoException e){
            LOGGER.warn("Sorting failed failed",e);
            throw new ServiceException("Sorting failed",e);
        }
    }

    @Override
    public List<Order> getThreeLastGuests(Integer roomId) {
        List<Order> orders=orderDao.getAll().stream().filter(h1->h1.getRoom().getId().equals(roomId)).limit(3).collect(Collectors.toList());
        return orders;
    }

    public int getDaysBetweenDates(LocalDate checkInDate,LocalDate checkOutDate){
        long daysBetween =  Duration.between(checkInDate.atStartOfDay(), checkOutDate.atStartOfDay()).toDays();
        int daysBetween1=toIntExact(daysBetween);
        return daysBetween1;
    }

}
