package com.hotel.ui.actions.order;

import com.hotel.model.Room;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;

public class GetFreeRoomByDate extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            System.out.println("Введите дату");
            String dateString=reader.readLine();
            LocalDate date=LocalDate.parse(dateString);
            List<Room> rooms=hotelFacade.getFreeRoomByFixedDate(date);
            System.out.println(rooms);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
