package com.senlainc.util;

public class IDGenerator {
    private static Integer guestId = 1;
    private static Integer roomId=1;
    private static Integer orderId=1;

    public static  Integer generateGuestId()
    {
        return guestId++;
    }
    public static Integer generateRoomId()
    {
        return roomId++;
    }
    public static Integer generateOrderId()
    {
        return orderId++;
    }
}
