package api.service;

import model.Order;

public interface IAdministratorService {
    long getAllAmount(Order order);
    Order getDaysInOrder(Order order,Integer day);
}
