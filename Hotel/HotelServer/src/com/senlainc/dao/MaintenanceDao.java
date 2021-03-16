package com.senlainc.dao;

import com.senlainc.api.dao.IMaintenanceDao;
import com.senlainc.model.Guest;
import com.senlainc.model.Maintenance;
import com.senlainc.util.SerializationHandler;

import java.util.List;

public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {

    public MaintenanceDao() {
        List<Maintenance> maintenances= SerializationHandler.deserialize(Maintenance.class);
        this.saveAll(maintenances);
    }

    @Override
    public void saveAll(List<Maintenance> entity) {
        getRepository().addAll(entity);
    }
}
