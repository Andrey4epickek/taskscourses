package com.hotel.service;

import com.hotel.api.dao.IGuestDao;
import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.api.dao.IOrderDao;
import com.hotel.api.dao.IRoomDao;
import com.hotel.api.service.IOrderService;
import com.hotel.config.CustomLogger;
import com.hotel.comparators.GuestNameComparator;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.hotel.model.Guest;
import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.Room;
import com.hotel.IDGenerator;
import com.hotel.comparators.OrderCheckOutDateComparator;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class OrderService implements IOrderService {

    private static final Logger LOGGER=Logger.getLogger(CustomLogger.class.getName());
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
            LOGGER.log(Level.INFO,String.format("Creating of order"));
        Order order=new Order(room,guest,checkInDate,checkOutDate, maintenanceDao.getAll());
        order.setId(IDGenerator.generateOrderId());
        orderDao.save(order);
        return order;
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Creating failed",e);
            throw new ServiceException("Creating failed",e);
        }
    }

    @Override
    public void evict(Integer guestId, Integer orderId,Integer roomId) {
        try {
            LOGGER.log(Level.INFO,String.format("Eviction of a guest %d, order %d, room %d",guestId,orderId,roomId));
        Room room= roomDao.getByid(roomId);
        Guest guest= guestDao.getByid(guestId);
        room.getGuests().remove(guest);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Eviction failed",e);
            throw new ServiceException("Eviction failed",e);
        }
    }

    @Override
    public void checkIn(Integer guestId,Integer roomId) {
        try {
            LOGGER.log(Level.INFO,String.format("checkIn  guest %d to room number %d",guestId,roomId));
        Room room=roomDao.getByid(roomId);
        Guest guest=guestDao.getByid(guestId);
        room.getGuests().add(guest);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"CheckIn failed",e);
            throw new ServiceException("CheckIn failed",e);
        }
    }

    @Override
    public int countCost(Integer orderId) {
        try {
            LOGGER.log(Level.INFO,String.format("count cost for order %d",orderId));
        Order costCountOrder=orderDao.getByid(orderId);
        int cost=0;
        for(Maintenance maintenance:costCountOrder.getMaintenances()){
            cost=cost+getDaysBetweenDates(costCountOrder.getCheckInDate(),costCountOrder.getCheckOutDate())*maintenance.getPrice();
        }
        costCountOrder.setCost(cost);
        return cost;
    }catch (DaoException e){
        LOGGER.log(Level.WARNING,"counting failed",e);
        throw new ServiceException("counting failed",e);
    }
    }

    @Override
    public void addService(Integer maintenanceId,Integer orderId) {
        try {
            LOGGER.log(Level.INFO,String.format("adding service for order %d",orderId));
            Order order=orderDao.getByid(orderId);
            Maintenance maintenance=maintenanceDao.getByid(maintenanceId);
            order.getMaintenances().add(maintenance);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Adding service failed",e);
            throw new ServiceException("Adding service failed",e);
        }
    }

    @Override
    public Order getOrder(Integer orderId) {
        try {
            LOGGER.log(Level.INFO,String.format("getting order %d",orderId));
        return orderDao.getByid(orderId);
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Getting order failed",e);
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
            LOGGER.log(Level.INFO,String.format("sorting guest services for order %d",orderId));
        List<Maintenance> maintenances=getOrder(orderId).getMaintenances();
        maintenances.sort((s1,s2)->s1.getPrice()-s2.getPrice());
        return maintenances;
        }catch (DaoException e){
            LOGGER.log(Level.WARNING,"Sorting failed failed",e);
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
