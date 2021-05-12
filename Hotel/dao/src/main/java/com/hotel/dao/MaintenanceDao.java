package com.hotel.dao;

import com.hotel.api.dao.IMaintenanceDao;
import com.hotel.model.Maintenance;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {
    public MaintenanceDao(){

    }
    public MaintenanceDao(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    protected Class<Maintenance> getClazz() {
        return Maintenance.class;
    }

//    private static final String INSERT_QUERY="INSERT INTO MAINTENANCES (name,price) VALUES (?,?);";
//    private static final String UPDATE_QUERY="UPDATE MAINTENANCE SET name=?,age=?";
//    private static final String TABLE_NAME="maintenances";
//    public MaintenanceDao() {
//        List<Maintenance> maintenances= SerializationHandler.deserialize(Maintenance.class);
//        this.saveAll(maintenances);
//    }

//    @Override
//    public void saveAll(List<Maintenance> entity) {
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
//    protected void prepareStatementForUpdate(PreparedStatement statement, Maintenance entity) throws SQLException {
//        statement.setString(1, entity.getName());
//        statement.setInt(2,entity.getPrice());
//    }
//
//
//    @Override
//    protected void prepareStatementForCreate(PreparedStatement statement, Maintenance entity) throws SQLException {
//        statement.setString(1, entity.getName());
//        statement.setInt(2,entity.getPrice());
//    }
//
//    @Override
//    protected String getTableName() {
//        return TABLE_NAME;
//    }
}
