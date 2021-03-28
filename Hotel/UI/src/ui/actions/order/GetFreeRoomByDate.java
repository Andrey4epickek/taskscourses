package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;

public class GetFreeRoomByDate extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите дату");
            String dateString=reader.readLine();
            LocalDate date=LocalDate.parse(dateString);
            List<Room> rooms=hotelFacade.getFreeRoomByFixedDate(date);
            System.out.println(rooms);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
