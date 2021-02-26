package hotel.ui.actions.order;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.Maintenance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddService extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите название услуги");
            String MaintenanceNameString=reader.readLine();
            System.out.println("Ведите стоимость услуги");
            int MaintenancePrice =reader.read();
            Maintenance maintenance=new Maintenance(MaintenanceNameString,MaintenancePrice);
            System.out.println("Введите Id заказа");
            String orderIdString=reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            hotelFacade.addService(maintenance,orderId);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
