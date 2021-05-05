package ui.actions.guest;

import com.model.Guest;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.List;

public class GetAllGuests extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Guest> guests=hotelFacade.getAllGuests();
        System.out.println(guests);
    }
}
