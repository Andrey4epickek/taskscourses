package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Maintenance;;
import java.util.logging.Level;

public class AddService extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите название услуги");
            String MaintenanceNameString=reader.readLine();
            System.out.println("Ведите стоимость услуги");
            String priceString =reader.readLine();
            Integer price =Integer.parseInt(priceString);
            Maintenance maintenance=new Maintenance(MaintenanceNameString,price);
            System.out.println("Введите Id заказа");
            String orderIdString=reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            hotelFacade.addService(maintenance,orderId);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
