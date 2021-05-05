package ui.actions.room;

import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class ChangePrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            System.out.println("Введите цену");
            String  priceString=reader.readLine();
            Integer price=Integer.parseInt(priceString);
            hotelFacade.changePrice(roomId,price);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
