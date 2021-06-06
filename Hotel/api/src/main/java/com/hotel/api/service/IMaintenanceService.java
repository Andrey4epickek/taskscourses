package com.hotel.api.service;

import com.hotel.model.Maintenance;
import com.hotel.model.Order;
import com.hotel.model.dto.MaintenanceDto;
import com.hotel.model.dto.OrderDto;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price, OrderDto orderDto);
    List<MaintenanceDto> getAll();
    MaintenanceDto getById(Integer maintenanceId);
    void deleteMaintenance(Integer maintenanceId);
}
