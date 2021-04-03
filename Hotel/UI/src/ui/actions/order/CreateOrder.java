package ui.actions.order;

import com.facade.HotelFacade;
import ui.actions.AbstractAction;
import ui.actions.IAction;
import com.model.Guest;
import com.model.Order;
import com.model.Room;

import java.time.LocalDate;
import java.util.logging.Level;


public class CreateOrder extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
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
        }catch (Exception e){
            LOGGER.log(Level.WARNING,e.getLocalizedMessage(),e);
        }
    }
}
