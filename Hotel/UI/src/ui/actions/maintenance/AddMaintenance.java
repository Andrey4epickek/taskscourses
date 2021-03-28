package ui.actions.maintenance;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Maintenance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class AddMaintenance extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите название услуги");
            String name=reader.readLine();
            System.out.println("Ведите стоимость услуги");
            String priceString =reader.readLine();
            Integer price =Integer.parseInt(priceString);
            Maintenance maintenance=hotelFacade.addService(name,price);
            System.out.println(maintenance);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
