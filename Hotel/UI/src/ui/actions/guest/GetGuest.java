package ui.actions.guest;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Guest;

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

