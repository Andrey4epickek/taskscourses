package com.hotel.ui.actions.maintenance;

import com.hotel.model.Maintenance;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

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
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
