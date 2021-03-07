package com.senlainc.service;

import com.senlainc.api.service.IAdministratorService;
import com.senlainc.model.Maintenance;
import com.senlainc.model.Order;

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
