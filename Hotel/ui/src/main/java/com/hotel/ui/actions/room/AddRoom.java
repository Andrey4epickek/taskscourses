package com.hotel.ui.actions.room;


import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.logging.Level;

public class AddRoom extends AbstractAction implements IAction {


    @Override
    public void execute() {
        try{
            System.out.println("Введите номер комнаты");
            String  numberString=reader.readLine();
            Integer number=Integer.parseInt(numberString);
            System.out.println("Ведите вместимость комнаты");
            String capacityString=reader.readLine();
            Integer capacity=Integer.parseInt(capacityString);
            System.out.println("Введите цену комнаты");
            String  priceString=reader.readLine();
            Integer price=Integer.parseInt(priceString);
            System.out.println("Введите кол-во звезд в комнате");
            String  starsString=reader.readLine();
            Integer stars=Integer.parseInt(starsString);
            RoomStatus status=RoomStatus.OPEN;
            Room room= hotelFacade.addRoom(number,capacity,price,stars,status);
            System.out.println(room);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
