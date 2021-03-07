package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Maintenance;

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
            String priceString =reader.readLine();
            Integer price =Integer.parseInt(priceString);
            Maintenance maintenance=new Maintenance(MaintenanceNameString,price);
            System.out.println("Введите Id заказа");
            String orderIdString=reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            hotelFacade.addService(maintenance,orderId);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
