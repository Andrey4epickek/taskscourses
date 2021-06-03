package com.hotel.ui.actions.order;

import com.hotel.model.Guest;
import com.hotel.model.Order;
import com.hotel.model.Room;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.time.LocalDate;


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
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
