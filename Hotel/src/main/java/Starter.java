
import com.hotel.config.CustomLogger;
import com.hotel.injection.ApplicationContext;
import com.hotel.model.*;
public class Starter {
    private static final ApplicationContext applicationContext=ApplicationContext.getInstance();
        public static void main(String[] args) {
            new CustomLogger();

            Guest guest=applicationContext.guestService().addGuest("vasya",20);
            System.out.println(guest);
            System.out.println(applicationContext.guestDao().getAll());

            Room room=applicationContext.roomService().addRoom(1,3,30,3, RoomStatus.OPEN,1);
            System.out.println(room);
            System.out.println(applicationContext.roomDao().getByid(1));
        }

}


