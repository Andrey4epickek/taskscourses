package com.service;


import com.api.dao.IMaintenanceDao;
import com.api.service.IMaintenanceService;
import com.dao.MaintenanceDao;
import com.model.Maintenance;
import com.util.IDGenerator;

import java.util.List;

public class MaintenanceService implements IMaintenanceService {
    private IMaintenanceDao maintenanceDao;

    public MaintenanceService(IMaintenanceDao maintenanceDao){
        this.maintenanceDao=maintenanceDao;
    }

    @Override
    public Maintenance addService(String name, Integer price) {
        Maintenance maintenance=new Maintenance(name,price);
        maintenance.setId(IDGenerator.generateMaintenanceId());
        maintenanceDao.save(maintenance);
        return maintenance;
    }

    @Override
    public List<Maintenance> getAllServices() {
        return maintenanceDao.getAll();
    }
}
