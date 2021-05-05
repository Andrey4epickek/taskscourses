package ui.actions.room;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Room;

import java.util.List;

public class GetSortRoomByStars extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Room> rooms= hotelFacade.getSortRoomByStars();
        System.out.println(rooms);
    }
}
