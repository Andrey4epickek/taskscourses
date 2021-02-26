package hotel.ui.actions.room;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.Room;

import java.util.List;

public class GetSortRoomByCapacity extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Room> rooms= hotelFacade.getSortRoomByCapacity();
        System.out.println(rooms);
    }
}
