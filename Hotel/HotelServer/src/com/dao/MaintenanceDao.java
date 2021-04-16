package com.dao;

import com.api.dao.IMaintenanceDao;
import com.model.Maintenance;
import com.util.SerializationHandler;

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
