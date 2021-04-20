package ui.actions.order;


import com.model.Maintenance;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.List;
import java.util.logging.Level;

public class GetServicesSortByPrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id заказа");
            String orderIdString =reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            List<Maintenance> maintenances=hotelFacade.getGuestServicesSortByPrice(orderId);
            System.out.println(maintenances);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}