package ui.actions.room;

import com.Load.LoadConfig;
import com.util.PropertiesHandler;
import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.RoomStatus;

import java.util.logging.Level;

public class ChangeStatus extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            Boolean prop=LoadConfig.getStatus();
            if(prop==true) {
                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                RoomStatus status = RoomStatus.CLOSED;
                hotelFacade.changeStatus(status, roomId);
            }
            else{
                System.out.println("You cant change room status");
            }
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
