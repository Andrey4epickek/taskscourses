package util;

public class IDGenerator {
    private static Long guestId = 1L;
    private static Long roomId=1L;

    public static  Long generateGuestId()
    {
        return guestId++;
    }
    public static Long generateRoomId()
    {
        return roomId++;
    }
}
