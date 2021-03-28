package ui.actions.guest;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class GetGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id гостя для поиска");
            String guestIdString=reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            Guest guest= hotelFacade.getGuest(guestId);
            System.out.println(guest);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}

