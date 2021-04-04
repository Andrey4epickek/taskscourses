package com.service;


import com.api.service.IMaintenanceService;
import com.dao.MaintenanceDao;
import com.model.Maintenance;
import com.util.IDGenerator;

import java.util.List;

public class MaintenanceService implements IMaintenanceService {
    private static MaintenanceService instance;

    public static MaintenanceService getInstance(){
        if(instance==null){
            instance=new MaintenanceService();
        }
        return instance;
    }


    @Override
    public Maintenance addService(String name, Integer price) {
        Maintenance maintenance=new Maintenance(name,price);
        maintenance.setId(IDGenerator.generateMaintenanceId());
        MaintenanceDao.getInstance().save(maintenance);
        return maintenance;
    }

    @Override
    public List<Maintenance> getAllServices() {
        return MaintenanceDao.getInstance().getAll();
    }
}
