package ui.actions.guest;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Guest;

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

