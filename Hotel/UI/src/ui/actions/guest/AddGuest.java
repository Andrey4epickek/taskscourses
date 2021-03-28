package ui.actions.guest;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class AddGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите имя гостя ");
            String guestName=reader.readLine();
            System.out.println("Введите возраст гостя ");
            String ageString=reader.readLine();
            Integer guestAge=Integer.parseInt(ageString);
            Guest guest= hotelFacade.addGuest(guestName,guestAge);
            System.out.println(guest);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}

