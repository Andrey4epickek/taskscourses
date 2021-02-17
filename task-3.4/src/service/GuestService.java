package service;

import api.dao.IGuestDao;
import api.service.IGuestService;
import model.Guest;
import util.IDGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class GuestService implements IGuestService {
    private final IGuestDao guestDao;

    public GuestService(IGuestDao guestDao) {
        this.guestDao = guestDao;
        }

    @Override
    public List<Long> getAllGuestId() {
        return (guestDao.getAll().stream().map(Guest::getId).collect(Collectors.toList()));
    }

    @Override
        public Guest addGuest(String name, Integer age){
            Guest guest=new Guest(name,age);
            guest.setId(IDGenerator.generateGuestId());
            guestDao.save(guest);
            return guest;
    }

    @Override
    public Guest getGuest(Long guestId) {
        if(getAllGuestId().contains(guestId)){
            return guestDao.getByid(guestId);
        }
        else{
            System.out.println("Thereis no such guest");
        }
        return null;
    }

}
