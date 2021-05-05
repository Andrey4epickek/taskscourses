package com.dao.util;

import com.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityMapper {

    public static AEntity parseResultSet(ResultSet resultSet,String tableName){
        try{
            switch (tableName){
                case"guests":
                    return createGuest(resultSet);
                case"rooms":
                    return createRoom(resultSet);
                case "maintenances":
                    return createMaintenance(resultSet);
                case "orders":
                    return createOrder(resultSet);
                default:
                    throw new RuntimeException("Unknown table: "+tableName);
            }
        }catch (SQLException e){
            throw new RuntimeException("Parsing exception",e);
        }
    }

    private static Guest createGuest(ResultSet resultSet) throws SQLException{
        Guest guest=new Guest();
        guest.setId(resultSet.getInt("id"));
        guest.setName(resultSet.getString("name"));
        guest.setAge(resultSet.getInt("age"));
        return guest;
    }

    private static Room createRoom(ResultSet resultSet) throws  SQLException{
        Room room=new Room();
        Guest guest=new Guest();
        guest.setId(resultSet.getInt("guests_id"));
        room.setId(resultSet.getInt("id"));
        room.setNumber(resultSet.getInt("number"));
        room.setCapacity(resultSet.getInt("capacity"));
        room.setPrice(resultSet.getInt("price"));
        room.setStars(resultSet.getInt("stars"));
        room.setStatus(RoomStatus.valueOf(resultSet.getString("status")));
        List<Guest>guests=new ArrayList<>();
        guests.add(guest);
        room.setGuests(guests);
        return room;
    }

    private static Maintenance createMaintenance(ResultSet resultSet) throws  SQLException{
        Maintenance maintenance=new Maintenance();
        maintenance.setId(resultSet.getInt("id"));
        maintenance.setName(resultSet.getString("name"));
        maintenance.setPrice(resultSet.getInt("price"));
        return maintenance;
    }

    private static Order createOrder(ResultSet resultSet) throws  SQLException{
        Order order=new Order();
        order.setId(resultSet.getInt("id"));
        order.setCheckInDate(resultSet.getDate("checkInDate").toLocalDate());
        order.setCheckOutDate(resultSet.getDate("checkOutDate").toLocalDate());
        return order;
    }
}
