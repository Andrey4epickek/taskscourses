package ui.actions.order;

import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.senlainc.model.Guest;
import com.senlainc.model.Order;
import com.senlainc.model.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;


public class CreateOrder extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите Id комнаты");
            String roomIdString=reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            Room room= hotelFacade.getById(roomId);
            System.out.println("Введите Id гостя");
            String guestIdString=reader.readLine();
            Integer guestId=Integer.parseInt(guestIdString);
            Guest guest= hotelFacade.getGuest(guestId);
            System.out.println("Введите checkInDate");
            String checkInDateString=reader.readLine();
            LocalDate checkInDate=LocalDate.parse(checkInDateString);
            System.out.println("Введите checkOutDate");
            String checkOutDateString=reader.readLine();
            LocalDate checkOutDate=LocalDate.parse(checkOutDateString);
            Order order= hotelFacade.createOrder(room,guest,checkInDate,checkOutDate);
            System.out.println(order);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
