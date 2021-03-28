package com.senlainc.service;


import com.senlainc.api.service.IMaintenanceService;
import com.senlainc.dao.MaintenanceDao;
import com.senlainc.model.Maintenance;

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
        MaintenanceDao.getInstance().save(maintenance);
        return maintenance;
    }
}
