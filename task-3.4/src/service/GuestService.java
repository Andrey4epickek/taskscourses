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
    public List<Integer> getAllGuestId() {
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
    public Guest getGuest(Integer guestId) {
        if(getAllGuestId().contains(guestId)){
            return guestDao.getByid(guestId);
        }
        else{
            System.out.println("There is no such guest");
        }
        return null;
    }

}
