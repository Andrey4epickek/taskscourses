package com.hotel.ui.actions.order;

import com.hotel.Load.LoadConfig;
import com.hotel.model.Order;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.io.IOException;
import java.util.List;

public class GetThreeLastGuests extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            Boolean prop1= LoadConfig.getHistory();
            if(prop1==true) {
                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                List<Order> order = hotelFacade.getThreeLastGuests(roomId);
                System.out.println(order);
            }
            else{
                System.out.println("You cant get history");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
