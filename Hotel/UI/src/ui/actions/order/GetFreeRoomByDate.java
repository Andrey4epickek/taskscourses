package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class GetFreeRoomByDate extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите дату");
            String dateString=reader.readLine();
            LocalDate date=LocalDate.parse(dateString);
            List<Room> rooms=hotelFacade.getFreeRoomByFixedDate(date);
            System.out.println(rooms);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
