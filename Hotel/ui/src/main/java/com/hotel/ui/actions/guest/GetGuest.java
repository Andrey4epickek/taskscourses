package com.hotel.ui.actions.guest;

import com.hotel.model.Guest;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

public class GetGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id гостя для поиска");
            String guestIdString=reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            Guest guest= hotelFacade.getGuest(guestId);
            System.out.println(guest);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}

