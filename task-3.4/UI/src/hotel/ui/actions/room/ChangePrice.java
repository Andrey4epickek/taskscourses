package hotel.ui.actions.room;

import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.RoomStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangePrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            System.out.println("Введите цену");
            String  priceString=reader.readLine();
            Integer price=Integer.parseInt(priceString);
            hotelFacade.changePrice(roomId,price);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
