package com.api.service;

import com.model.Maintenance;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price);
}
