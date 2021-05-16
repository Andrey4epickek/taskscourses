package com.hotel.ui.actions.guest;

import com.hotel.dao.RoomDao;
import com.hotel.config.EntityManagerUtil;
import com.hotel.model.Guest;
import com.hotel.ui.actions.AbstractAction;
import com.hotel.ui.actions.IAction;

import javax.persistence.EntityManager;

public class AddGuest extends AbstractAction implements IAction {
    private static final EntityManagerUtil emu=new EntityManagerUtil();
    EntityManager entityManager= emu.getEntityManager();
    @Override
    public void execute() {
        try{
            System.out.println("Введите имя гостя ");
            String guestName=reader.readLine();
            System.out.println("Введите возраст гостя ");
            String ageString=reader.readLine();
            Integer guestAge=Integer.parseInt(ageString);
            System.out.println("Введите id комнаты для поселения");
            String roomIdString=reader.readLine();
            Integer roomId=Integer.parseInt(roomIdString);
            RoomDao roomDao=new RoomDao(entityManager);
            Guest guest= hotelFacade.addGuest(guestName,guestAge,roomDao.getByid(roomId));
            System.out.println(guest);
        }catch (Exception e){
            LOGGER.warn(e.getLocalizedMessage(),e);
        }
    }
}

