package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Evict extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id гостя");
            String guestIdString =reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            System.out.println("Ведите Id заказа");
            String orderIdString =reader.readLine();
            Integer orderId=Integer.parseInt(orderIdString);
            System.out.println("Ведите Id комнаты");
            String roomIdString =reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            hotelFacade.evict(guestId,orderId,roomId);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
