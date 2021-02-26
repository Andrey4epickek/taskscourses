package service;

import api.dao.IMaintenanceDao;
import api.dao.IOrderDao;
import api.service.IMaintenanceService;
import model.Maintenance;


import java.util.ArrayList;
import java.util.List;

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
