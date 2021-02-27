package hotel.ui.actions.room;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.RoomStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeStatus extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            RoomStatus status=RoomStatus.CLOSED;
            hotelFacade.changeStatus(status,roomId);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
