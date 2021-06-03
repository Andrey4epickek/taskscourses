package com.hotel.ui.actions.order;

import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

public class CheckIn extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id гостя");
            String guestIdString =reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            System.out.println("Ведите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            hotelFacade.checkIn(guestId,roomId);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
