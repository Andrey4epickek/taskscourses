package com.senlainc.service;

import com.senlainc.api.dao.IMaintenanceDao;
import com.senlainc.api.dao.IOrderDao;
import com.senlainc.api.service.IMaintenanceService;
import com.senlainc.model.Maintenance;

public class MaintenanceService implements IMaintenanceService {

    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;

    public MaintenanceService(IMaintenanceDao maintenanceDao, IOrderDao orderDao) {
        this.maintenanceDao = maintenanceDao;
        this.orderDao = orderDao;
    }

    @Override
    public Maintenance addService(String name, Integer price) {
        Maintenance maintenance=new Maintenance(name,price);
        maintenanceDao.save(maintenance);
        return maintenance;
    }
}
