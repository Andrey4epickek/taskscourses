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
import com.hotel.comparators.OrderCheckOutDateComparator;
import com.hotel.model.dto.GuestDto;
import com.hotel.model.dto.OrderDto;
import com.hotel.model.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Math.toIntExact;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {

    private static final Logger LOGGER= LogManager.getLogger(OrderService.class.getName());
    private final IOrderDao orderDao;
    private final IMaintenanceDao maintenanceDao;
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;
    private final ModelMapper mapper;

    @Override
    public Order create(RoomDto roomDto, GuestDto guestDto, LocalDate checkInDate, LocalDate checkOutDate) {
        try {
            LOGGER.info(String.format("Creating of order"));
            Order order=new Order();
            Room room=mapper.map(roomDto,Room.class);
            order.setRoom(room);
            Guest guest=mapper.map(guestDto,Guest.class);
            order.setGuest(guest);
            order.setCheckInDate(checkInDate);
            order.setCheckOutDate(checkOutDate);
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
            guest.setRoom(null);
            guestDao.update(guest);
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
            guest.setRoom(room);
            roomDao.update(room);
            guestDao.update(guest);
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
    public OrderDto getById(Integer orderId) {
        try {
            LOGGER.info(String.format("getting order %d",orderId));
        Order order=orderDao.getByid(orderId);
        return mapper.map(order,OrderDto.class);
        }catch (DaoException e){
            LOGGER.warn("Getting order failed",e);
            throw new ServiceException("Getting order failed",e);
        }
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Order order=orderDao.getByid(orderId);
        orderDao.delete(order);
    }

    @Override
    public List<Order> getSortedGuestsByName() {
        List<Order> orderList=orderDao.getAll();
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
    public List<OrderDto> getAll() {
        List<Order> ordersList=orderDao.getAll();
        ordersList.sort(((o1, o2) -> o1.getCost()- o2.getCost()));
        List<OrderDto> orderDtos=new ArrayList<>();
        for(Order order:ordersList){
            OrderDto orderDto=mapper.map(order,OrderDto.class);
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    @Override
    public List<Room> getFreeRoomByFixedDate(LocalDate date) {
        List<Order>orders=orderDao.getAll();
        return orders.stream().filter(o1->o1.getCheckOutDate().isBefore(date)).map(Order::getRoom).collect(Collectors.toList());
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