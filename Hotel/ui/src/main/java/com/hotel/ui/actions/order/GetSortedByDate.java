package com.hotel.ui.actions.order;

import com.hotel.model.Order;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.List;

public class GetSortedByDate extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Order> order= hotelFacade.ordersSortedByCheckOutDate();
        System.out.println(order);
    }
}
