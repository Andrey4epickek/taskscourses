package com.hotel.ui.actions.order;

import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;


public class AddService extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите id услуги");
            String maintenanceIdString=reader.readLine();
            Integer maintenanceId=Integer.parseInt(maintenanceIdString);
            System.out.println("Введите Id заказа");
            String orderIdString=reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            hotelFacade.addService(maintenanceId,orderId);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
