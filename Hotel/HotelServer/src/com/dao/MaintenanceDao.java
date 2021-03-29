package com.dao;

import com.api.dao.IMaintenanceDao;
import com.model.Maintenance;
import com.util.SerializationHandler;

import java.util.List;

public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {
    private static MaintenanceDao instance;

    public static MaintenanceDao getInstance(){
        if(instance==null){
            instance=new MaintenanceDao();
        }
        return instance;
    }

//    public MaintenanceDao() {
//        List<Maintenance> maintenances= SerializationHandler.deserialize(Maintenance.class);
//        this.saveAll(maintenances);
//    }

    @Override
    public void saveAll(List<Maintenance> entity) {
        getRepository().addAll(entity);
    }
}
