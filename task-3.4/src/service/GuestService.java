package service;

import api.dao.IGuestDao;
import api.service.IGuestService;
import model.Guest;
import util.IDGenerator;

public class GuestService implements IGuestService {
    private final IGuestDao guestDao;

    public GuestService(IGuestDao guestDao) {
        this.guestDao = guestDao;
        }

        @Override
        public Guest addGuest(String name, Integer age){
            Guest guest=new Guest(name,age);
            guest.setId(IDGenerator.generateGuestId());
            guestDao.save(guest);
            return guest;
    }

}
