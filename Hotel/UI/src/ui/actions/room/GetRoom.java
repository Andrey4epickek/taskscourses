package ui.actions.room;


import com.model.Room;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.logging.Level;

public class GetRoom extends AbstractAction implements IAction {

    @Override
    public void execute() {
        try{
            System.out.println("Введите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            Room room= hotelFacade.getRoom(roomId);
            System.out.println(room);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
