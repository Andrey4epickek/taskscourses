package com.senlainc.api.service;

import com.senlainc.model.Order;

public interface IAdministratorService {
    long getAllAmount(Order order);
    Order getDaysInOrder(Order order,Integer day);
}
