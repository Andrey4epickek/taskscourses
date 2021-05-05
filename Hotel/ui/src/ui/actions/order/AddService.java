package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Maintenance;;
import java.util.logging.Level;

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
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
