package com.hotel.api.service;

import com.hotel.model.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price);
    List<Maintenance> getAllServices();
}
