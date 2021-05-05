package com.injection;

import com.api.dao.IGuestDao;
import com.api.dao.IMaintenanceDao;
import com.api.dao.IOrderDao;
import com.api.dao.IRoomDao;
import com.api.service.IGuestService;
import com.api.service.IMaintenanceService;
import com.api.service.IOrderService;
import com.api.service.IRoomService;
import com.dao.GuestDao;
import com.dao.MaintenanceDao;
import com.dao.OrderDao;
import com.dao.RoomDao;
import com.facade.HotelFacade;
import com.service.GuestService;
import com.service.MaintenanceService;
import com.service.OrderService;
import com.service.RoomService;

public class ApplicationContext {
    private static ApplicationContext instance;

    public static ApplicationContext getInstance(){
        if(instance==null){
            instance=new ApplicationContext();
        }
        return instance;
    }

    public ApplicationContext(){
    }

    private IRoomDao roomDao;
    private IRoomService roomService;
    private IGuestDao guestDao;
    private IGuestService guestService;
    private IMaintenanceDao maintenanceDao;
    private IMaintenanceService maintenanceService;
    private IOrderDao orderDao;
    private IOrderService orderService;
    private HotelFacade hotelFacade;

    public IRoomDao roomDao(){
        if(roomDao==null){
            roomDao=new RoomDao();
        }
        return roomDao;
    }

    public IRoomService roomService(){
        if(roomService==null){
            roomService=new RoomService(roomDao(),guestDao());
        }
        return roomService;
    }

    public IGuestDao guestDao(){
        if(guestDao==null){
            guestDao=new GuestDao();
        }
        return guestDao;
    }

    public IGuestService guestService(){
        if(guestService==null){
            guestService=new GuestService(guestDao());
        }
        return guestService;
    }

    public IMaintenanceDao maintenanceDao(){
        if(maintenanceDao==null){
            maintenanceDao=new MaintenanceDao();
        }
        return maintenanceDao;
    }

    public IMaintenanceService maintenanceService(){
        if(maintenanceService==null){
            maintenanceService=new MaintenanceService(maintenanceDao());
        }
        return maintenanceService;
    }

    public IOrderDao orderDao(){
        if(orderDao==null){
            orderDao=new OrderDao();
        }
        return orderDao;
    }

    public IOrderService orderService(){
        if(orderService==null){
            orderService=new OrderService(orderDao(),maintenanceDao(),roomDao(),guestDao());
        }
        return orderService;
    }

    public HotelFacade hotelFacade(){
        if(hotelFacade==null){
            hotelFacade=new HotelFacade(guestService(),roomService(),orderService(),maintenanceService());
        }
        return hotelFacade;
    }

}
