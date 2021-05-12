package com.hotel.dao;

import com.hotel.api.dao.IRoomDao;
import com.hotel.model.Room;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class RoomDao extends AbstractDao<Room> implements IRoomDao{
//    private static final String INSERT_QUERY="INSERT INTO rooms (number,capacity,price,stars,status,guests_id) VALUES (?,?,?,?,?,?);";
//    private static final String UPDATE_QUERY="UPDATE rooms SET number=?,capacity=?,price=?,stars=?,status=?,guests_id=?";
//    private static final String TABLE_NAME="rooms";

//    public RoomDao() {
//        List<Room> rooms= SerializationHandler.deserialize(Room.class);
//       this.saveAll(rooms);
//    }
    public RoomDao(){

    }
    public RoomDao(EntityManager entityManager) {
        this.entityManager=entityManager;
    }



    @Override
    protected Class<Room> getClazz() {
        return Room.class;
    }

//    @Override
//    public void saveAll(List<Room> entity) {
//        getRepository().addAll(entity);
//    }
//
//    @Override
//    protected String getInsertQuery() {
//        return INSERT_QUERY;
//    }
//
//    @Override
//    protected String getUpdateQuery() {
//        return UPDATE_QUERY;
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, Room entity) throws SQLException {
//        statement.setInt(1,entity.getNumber());
//        statement.setInt(2,entity.getCapacity());
//        statement.setInt(3,entity.getPrice());
//        statement.setInt(4,entity.getStars());
//        statement.setString(5,String.valueOf(entity.getStatus()));
//        statement.setInt(6, entity.getGuests().stream().mapToInt(a->a.getId()).sum());
//    }
//
//
//    @Override
//    protected void prepareStatementForCreate(PreparedStatement statement, Room entity) throws SQLException {
//        statement.setInt(1,entity.getNumber());
//        statement.setInt(2,entity.getCapacity());
//        statement.setInt(3,entity.getPrice());
//        statement.setInt(4,entity.getStars());
//        statement.setString(5,String.valueOf(entity.getStatus()));
//        statement.setInt(6, entity.getGuests().stream().mapToInt(a->a.getId()).sum());
//    }
//
//    @Override
//    protected String getTableName() {
//        return TABLE_NAME;
//    }
}
