package hotel.ui.actions.guest;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetGuest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id гостя для поиска");
            String guestIdString=reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            Guest guest= hotelFacade.getGuest(guestId);
            System.out.println(guest);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

