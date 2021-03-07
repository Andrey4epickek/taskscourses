package ui.actions.room;

import ui.actions.AbstractAction;
import ui.actions.IAction;

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
