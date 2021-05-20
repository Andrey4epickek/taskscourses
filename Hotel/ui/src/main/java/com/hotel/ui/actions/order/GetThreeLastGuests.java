package com.hotel.ui.actions.order;

import com.hotel.model.Order;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.io.IOException;
import java.util.List;

public class GetThreeLastGuests extends AbstractAction implements IAction {
    @Override
    public void execute() throws IOException {

                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                List<Order> order = hotelFacade.getThreeLastGuests(roomId);
                System.out.println(order);
        }
    }

