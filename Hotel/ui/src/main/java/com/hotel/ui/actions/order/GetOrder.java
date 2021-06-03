package com.hotel.ui.actions.order;

import com.hotel.model.Order;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;


public class GetOrder extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id заказа");
            String orderIdString =reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            Order order= hotelFacade.getOrder(orderId);
            System.out.println(order);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
