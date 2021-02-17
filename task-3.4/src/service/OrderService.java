package service;

import api.dao.IGuestDao;
import api.dao.IMaintenanceDao;
import api.dao.IOrderDao;
import api.dao.IRoomDao;
import api.service.IOrderService;

import model.Guest;
import model.Maintenance;
import model.Order;
import model.Room;
import util.Comparators.GuestNameComparator;
import util.Comparators.OrderCheckOutDateComparator;
import util.IDGenerator;
import static java.lang.Math.toIntExact;


import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements IOrderService {
    private final IRoomDao roomDao;
    private final IGuestDao guestDao;
    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;

    public OrderService(IRoomDao roomDao, IGuestDao guestDao, IMaintenanceDao maintenanceDao, IOrderDao orderDao) {
        this.roomDao = roomDao;
        this.guestDao = guestDao;
        this.maintenanceDao = maintenanceDao;
        this.orderDao = orderDao;
    }

    @Override
    public Order create(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        Order order=new Order(room,guest,checkInDate,checkOutDate,maintenanceDao.getAll());
        order.setId(IDGenerator.generateOrderId());
        orderDao.save(order);
        return order;
    }

    @Override
    public void evict(Long guestId, Long orderId,Long roomId) {
        Room room=roomDao.getByid(roomId);
        Guest guest=guestDao.getByid(guestId);
        room.getGuests().remove(guest);
    }

    @Override
    public void checkIn(Long guestId,Long roomId) {
        Room room=roomDao.getByid(roomId);
        Guest guest=guestDao.getByid(guestId);
        room.getGuests().add(guest);
    }

    @Override
    public void countCost(Long orderId) {
        Order costCountOrder=orderDao.getByid(orderId);
        int cost=0;
        for(Maintenance maintenance:costCountOrder.getMaintenances()){
            cost=cost+getDaysBetweenDates(costCountOrder.getCheckInDate(),costCountOrder.getCheckOutDate())*maintenance.getPrice();
        }
        costCountOrder.setCost(cost);
    }

    @Override
    public void addService(Maintenance maintenance,Long orderId) {
        orderDao.getByid(orderId).getMaintenances().add(maintenance);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderDao.getByid(orderId);
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
    public int getQuantityGuests() {
        List<Guest> guests=getAllGuestService().stream().collect(Collectors.toList());
        return guests.size();
    }

    @Override
    public List<Order> getAllOrderService() {
        return orderDao.getAll();
    }

    @Override
    public List<Guest> getAllGuestService() {
        return guestDao.getAll();
    }

    @Override
    public List<Room> getFreeRoomByFixedDate(LocalDate date) {
        List<Order>orders=orderDao.getAll();
        return orders.stream().filter(o1->o1.getCheckOutDate().isBefore(date)).map(Order::getRoom).collect(Collectors.toList());
    }

    @Override
    public List<Maintenance> getGuestServicesSortByPrice(Long orderId) {
        List<Maintenance> maintenances=getOrder(orderId).getMaintenances();
        maintenances.sort((s1,s2)->s1.getPrice()-s2.getPrice());
        return maintenances;
    }

    @Override
    public List<Order> getThreeLastGuests(Long roomId) {
        List<Order> orders=orderDao.getAll().stream().filter(h1->h1.getRoom().getId().equals(roomId)).limit(3).collect(Collectors.toList());
        return orders;
    }

    @Override
    public List<Long> getAllOrdersId() {
        return (orderDao.getAll().stream().map(Order::getId).collect(Collectors.toList()));
    }


    public int getDaysBetweenDates(LocalDate checkInDate,LocalDate checkOutDate){
        long daysBetween =  Duration.between(checkInDate.atStartOfDay(), checkOutDate.atStartOfDay()).toDays();
        int daysBetween1=toIntExact(daysBetween);
        return daysBetween1;
    }

}
