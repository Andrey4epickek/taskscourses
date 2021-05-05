package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Order;

import java.util.List;

public class GetSortedByName extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Order> order= hotelFacade.getSortedGuestsByName();
        System.out.println(order);
    }
}
