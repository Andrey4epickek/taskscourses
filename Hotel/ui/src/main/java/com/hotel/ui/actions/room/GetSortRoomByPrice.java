package com.hotel.ui.actions.room;

import com.hotel.model.Room;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.List;

public class GetSortRoomByPrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Room> rooms= hotelFacade.getSortRoomByPrice();
        System.out.println(rooms);
    }
}
