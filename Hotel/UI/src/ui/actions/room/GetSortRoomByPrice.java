package ui.actions.room;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Room;

import java.util.List;

public class GetSortRoomByPrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Room> rooms= hotelFacade.getSortRoomByPrice();
        System.out.println(rooms);
    }
}
