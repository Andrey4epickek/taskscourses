package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Order;

import java.util.List;

public class GetSortedByDate extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Order> order= hotelFacade.ordersSortedByCheckOutDate();
        System.out.println(order);
    }
}
