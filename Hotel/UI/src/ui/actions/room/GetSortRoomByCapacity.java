package ui.actions.room;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Room;

import java.util.List;

public class GetSortRoomByCapacity extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Room> rooms= hotelFacade.getSortRoomByCapacity();
        System.out.println(rooms);
    }
}