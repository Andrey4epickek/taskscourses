package com.hotel.dao;

import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.model.Maintenance;
import org.springframework.stereotype.Repository;



@Repository
public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {


    @Override
    protected Class<Maintenance> getClazz() {
        return Maintenance.class;
    }

}