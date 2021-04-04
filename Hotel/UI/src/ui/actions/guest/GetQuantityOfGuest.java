package ui.actions.guest;

import ui.actions.AbstractAction;
import ui.actions.IAction;

public class GetQuantityOfGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        int quantity= hotelFacade.getQuantityOfGuest();
        System.out.println(quantity);
    }
}
