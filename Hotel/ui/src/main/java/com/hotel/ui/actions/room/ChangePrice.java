package com.hotel.ui.actions.room;

import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

public class ChangePrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            System.out.println("Введите цену");
            String  priceString=reader.readLine();
            Integer price=Integer.parseInt(priceString);
            hotelFacade.changePrice(roomId,price);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
