import api.dao.IGuestDao;
import api.dao.IRoomDao;
import api.service.IGuestService;
import api.service.IRoomService;
import dao.GuestDao;
import dao.RoomDao;
import model.Guest;
import model.Room;
import model.RoomStatus;
import service.GuestService;
import service.RoomService;


public class Hotel {
    private static final IGuestDao guestDao=new GuestDao();
    private static final IGuestService guestService=new GuestService(guestDao);

    private static final IRoomDao roomDao=new RoomDao();
    private static final IRoomService roomService=new RoomService(roomDao,guestDao);

    public static void main(String[] args) {
        Guest guest1= guestService.addGuest("Vasiya",34);
        System.out.println(guestDao.getByid(1L));
        Room roomx=roomService.addRoom(1,3,30, RoomStatus.OPEN);
        System.out.println(roomx);
        Guest guest2=guestService.addGuest("Ivan",40);
        System.out.println(guestDao.getByid(2L));
        roomService.checkIn(2L,1L);
        System.out.println(roomx);
        roomService.changeStatus(RoomStatus.CLOSED,1L);
        System.out.println(roomx);
        roomService.evictGuest(1L,1L);
        System.out.println(roomx);
        roomService.changePrice(1L,45);
        System.out.println(roomx);
    }
}
