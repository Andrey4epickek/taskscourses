package com.hotel.ui.actions.guest;

import com.hotel.model.Guest;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.List;

public class GetAllGuests extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Guest> guests=hotelFacade.getAllGuests();
        System.out.println(guests);
    }
}
