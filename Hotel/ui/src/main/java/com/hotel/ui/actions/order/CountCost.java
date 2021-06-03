package com.hotel.ui.actions.order;

import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

public class CountCost extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id заказа");
            String orderIdString= reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            int cost= hotelFacade.countCost(orderId);
            System.out.println(cost);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
