package ui.actions.room;

import com.senlainc.util.PropertiesHandler;
import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.RoomStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeStatus extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            Boolean prop= PropertiesHandler.getProperty("server.room.change_status.enable")
                    .map(Boolean::valueOf)
                    .orElse(false);
            if(prop==true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                RoomStatus status = RoomStatus.CLOSED;
                hotelFacade.changeStatus(status, roomId);
            }
            else{
                System.out.println("You cant change room status");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
