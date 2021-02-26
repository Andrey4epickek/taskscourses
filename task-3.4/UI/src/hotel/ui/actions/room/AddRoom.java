package hotel.ui.actions.room;


import hotel.ui.actions.AbstractAction;
import hotel.ui.actions.IAction;
import model.Room;
import model.RoomStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddRoom extends AbstractAction implements IAction {


    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите номер комнаты");
            String  numberString=reader.readLine();
            Integer number=Integer.parseInt(numberString);
            System.out.println("Ведите вместимость комнаты");
            String capacityString=reader.readLine();
            Integer capacity=Integer.parseInt(capacityString);
            System.out.println("Введите цену комнаты");
            String  priceString=reader.readLine();
            Integer price=Integer.parseInt(priceString);
            System.out.println("Введите кол-во звезд в комнате");
            String  starsString=reader.readLine();
            Integer stars=Integer.parseInt(starsString);
            RoomStatus status=RoomStatus.OPEN;
            Room room= hotelFacade.addRoom(number,capacity,price,stars,status);
            System.out.println(room);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
