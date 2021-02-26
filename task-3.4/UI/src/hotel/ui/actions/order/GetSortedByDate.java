package hotel.ui.actions.order;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.Order;

import java.util.List;

public class GetSortedByDate extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Order> order= hotelFacade.getSortedGuestsByName();
        System.out.println(order);
    }
}
