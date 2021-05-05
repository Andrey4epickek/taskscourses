package ui.actions.room;


import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Room;
import com.model.RoomStatus;

import java.util.logging.Level;

public class AddRoom extends AbstractAction implements IAction {


    @Override
    public void execute() {
        try{
            System.out.println("Введите номер комнаты");
            String  numberString=reader.readLine();
            Integer number=Integer.parseInt(numberString);
            System.out.println("Ведите вместимость комнаты");
            String capacityString=reader.readLine();
            Integer capacity=Integer.parseInt(capacityString);
            System.out.println("Введите id гостя,которого надо заселить в комнату");
            String  guestIdString=reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            System.out.println("Введите цену комнаты");
            String  priceString=reader.readLine();
            Integer price=Integer.parseInt(priceString);
            System.out.println("Введите кол-во звезд в комнате");
            String  starsString=reader.readLine();
            Integer stars=Integer.parseInt(starsString);
            RoomStatus status=RoomStatus.OPEN;
            Room room= hotelFacade.addRoom(number,capacity,price,stars,status,guestId);
            System.out.println(room);
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
