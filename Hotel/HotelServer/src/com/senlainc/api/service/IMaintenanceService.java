package com.senlainc.api.service;

import com.senlainc.model.Maintenance;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price);
}
