package com.api.service;

import com.model.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price);
    List<Maintenance> getAllServices();
}
