package com.hotel.ui.actions.room;


import com.hotel.model.RoomStatus;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import java.io.IOException;


public class ChangeStatus extends AbstractAction implements IAction {
    @Override
    public void execute() throws IOException {

                System.out.println("Введите Id комнаты");
                String roomIdString = reader.readLine();
                Integer roomId = Integer.parseInt(roomIdString);
                RoomStatus status = RoomStatus.CLOSED;
                hotelFacade.changeStatus(status, roomId);

    }
}
