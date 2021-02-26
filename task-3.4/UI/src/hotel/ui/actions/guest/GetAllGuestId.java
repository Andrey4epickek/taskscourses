package hotel.ui.actions.guest;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import java.util.List;

public class GetAllGuestId extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Integer> guests=hotelFacade.getAllGuestId();
        System.out.println(guests);
    }
}
