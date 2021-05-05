package com.hotel.ui.actions.guest;

import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

public class GetQuantityOfGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        int quantity= hotelFacade.getQuantityOfGuest();
        System.out.println(quantity);
    }
}
