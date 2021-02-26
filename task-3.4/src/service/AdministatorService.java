package service;

import api.service.IAdministratorService;
import model.Maintenance;
import model.Order;

public class AdministatorService implements IAdministratorService {
    Maintenance maintenance;
    @Override
    public long getAllAmount(Order order) {

        return 1L;
    }

    @Override
    public Order getDaysInOrder(Order order, Integer day) {
        return null;
    }
}
