package com.hotel.service;


import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.api.service.IMaintenanceService;
import com.hotel.model.Maintenance;
import com.hotel.IDGenerator;
import com.hotel.model.Order;

import java.util.List;

public class MaintenanceService implements IMaintenanceService {
    private IMaintenanceDao maintenanceDao;

    public MaintenanceService(IMaintenanceDao maintenanceDao){
        this.maintenanceDao=maintenanceDao;
    }

    @Override
    public Maintenance addService(String name, Integer price, Order order) {
        Maintenance maintenance=new Maintenance(name,price,order);
        maintenanceDao.save(maintenance);
        return maintenance;
    }

    @Override
    public List<Maintenance> getAllServices() {
        return maintenanceDao.getAll();
    }
}
