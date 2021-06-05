package com.hotel.service;


import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.api.dao.IOrderDao;
import com.hotel.api.service.IMaintenanceService;
import com.hotel.model.Maintenance;
import com.hotel.IDGenerator;
import com.hotel.model.Order;
import com.hotel.model.dto.MaintenanceDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MaintenanceService implements IMaintenanceService {
    private final IMaintenanceDao maintenanceDao;
    private final IOrderDao orderDao;
    private final ModelMapper mapper;

    @Override
    public Maintenance addService(String name, Integer price, Integer orderId) {
        Maintenance maintenance=new Maintenance(name,price,orderDao.getByid(orderId));
        maintenanceDao.save(maintenance);
        return maintenance;
    }

    @Override
    public List<Maintenance> getAllServices() {
        return maintenanceDao.getAll();
    }

    @Override
    public MaintenanceDto getById(Integer maintenanceId) {
        Maintenance maintenance=maintenanceDao.getByid(maintenanceId);
        return mapper.map(maintenance, MaintenanceDto.class);
    }
}