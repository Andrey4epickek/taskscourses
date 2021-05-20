package com.hotel.service;


import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.api.service.IMaintenanceService;
import com.hotel.model.Maintenance;
import com.hotel.IDGenerator;
import com.hotel.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MaintenanceService implements IMaintenanceService {
    private final IMaintenanceDao maintenanceDao;

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
