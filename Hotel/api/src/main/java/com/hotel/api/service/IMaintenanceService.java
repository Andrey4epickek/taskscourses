package com.hotel.api.service;

import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.dto.MaintenanceDto;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price, Order order);
    List<Maintenance> getAllServices();
    MaintenanceDto getById(Integer maintenanceId);
}
