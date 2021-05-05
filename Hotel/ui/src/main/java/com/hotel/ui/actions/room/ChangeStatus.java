package com.hotel.ui.actions.room;

import com.hotel.Load.LoadConfig;
import com.hotel.model.RoomStatus;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.util.logging.Level;

public class ChangeStatus extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try{
            Boolean prop=LoadConfig.getStatus();
            if(prop==true) {
                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                RoomStatus status = RoomStatus.CLOSED;
                hotelFacade.changeStatus(status, roomId);
            }
            else{
                System.out.println("You cant change room status");
            }
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}
