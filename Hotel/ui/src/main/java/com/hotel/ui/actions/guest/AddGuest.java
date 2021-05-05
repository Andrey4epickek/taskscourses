package com.hotel.ui.actions.guest;

import com.hotel.model.Guest;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.logging.Level;

public class AddGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите имя гостя ");
            String guestName=reader.readLine();
            System.out.println("Введите возраст гостя ");
            String ageString=reader.readLine();
            Integer guestAge=Integer.parseInt(ageString);
            Guest guest= hotelFacade.addGuest(guestName,guestAge);
            System.out.println(guest);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}

