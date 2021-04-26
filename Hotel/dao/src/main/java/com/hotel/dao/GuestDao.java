package com.hotel.dao;

import com.hotel.api.dao.IGuestDao;
import com.hotel.model.Guest;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GuestDao extends AbstractDao<Guest> implements IGuestDao {

    private static final String INSERT_QUERY="INSERT INTO GUESTS (name,age) VALUES (?,?);";
    private static final String UPDATE_QUERY="UPDATE GUESTS SET name=?,age=?";
    private static final String TABLE_NAME="guests";
//   public GuestDao() {
//        List<Guest> guests= SerializationHandler.deserialize(Guest.class);
//        this.saveAll(guests);
//    }

    public void saveAll(List<Guest> entity) {
        getRepository().addAll(entity);
    }

    @Override
    protected String getInsertQuery() {
        return INSERT_QUERY;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Guest entity) throws SQLException {
        statement.setString(1,entity.getName());
        statement.setInt(2,entity.getAge());
    }


    @Override
    protected void prepareStatementForCreate(PreparedStatement statement, Guest entity) throws SQLException {
        statement.setString(1,entity.getName());
        statement.setInt(2,entity.getAge());
    }


    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


}
