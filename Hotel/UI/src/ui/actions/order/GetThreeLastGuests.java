package ui.actions.order;

import com.senlainc.model.Order;
import com.senlainc.util.PropertiesHandler;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GetThreeLastGuests extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            Boolean prop1= PropertiesHandler.getProperty("server.order.history.enable")
                    .map(Boolean::valueOf)
                    .orElse(false);
            if(prop1==true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                List<Order> order = hotelFacade.getThreeLastGuests(roomId);
                System.out.println(order);
            }
            else{
                System.out.println("You cant get history");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
