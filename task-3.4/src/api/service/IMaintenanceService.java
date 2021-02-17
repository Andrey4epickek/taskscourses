package api.service;

import model.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance addService(String name, Integer price);
}
