package hotel.ui.actions.maintenance;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.Maintenance;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddMaintenance extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите название услуги");
            String name=reader.readLine();
            System.out.println("Ведите стоимость услуги");
            String priceString =reader.readLine();
            Integer price =Integer.parseInt(priceString);
            Maintenance maintenance=hotelFacade.addService(name,price);
            System.out.println(maintenance);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
