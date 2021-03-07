package starter;

import com.senlainc.config.CustomLogger;
import com.senlainc.model.Guest;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        new CustomLogger();

        List<Guest> guests=List.of(new Guest("vasya",20),new Guest("andrey",19));
        System.out.println(guests);
    }

}
