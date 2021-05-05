package com.hotel.dao;

import com.hotel.dao.util.Connector;
import com.hotel.dao.util.EntityMapper;
import com.hotel.exceptions.DaoException;
import com.hotel.api.dao.GenericDao;
import com.hotel.model.AEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    private static final String GET_BY_ID_ERROR_MESSAGE="could not find an entity by id: %d";
    protected final Logger LOGGER= LogManager.getLogger(this.getClass().getName());
    @Deprecated
    private List<T> repository=new ArrayList<>();
    private List<T> repository1=new ArrayList<>();
    private final Connector connector=Connector.getInstance();

    @Deprecated
    public List<T> getRepository() {
        return repository;
    }

    @Override
    public T update(T entity){
        Connection connection=connector.getConnection();
        String sql=getUpdateQuery();
        try(PreparedStatement statement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            prepareStatementForUpdate(statement,entity);
            statement.executeUpdate();

            return entity;
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public T save(T entity) {
        Connection connection=connector.getConnection();
        String sql=getInsertQuery();
        try(PreparedStatement statement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            prepareStatementForUpdate(statement,entity);
            int affected=statement.executeUpdate();
            if(affected==1){
                ResultSet resultSet=statement.getGeneratedKeys();
                resultSet.next();
                entity.setId(resultSet.getInt(1));
            }else {
                throw  new DaoException("creation failed");
            }
            return entity;
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public T getByid(Integer id) {
        Connection connection=connector.getConnection();
        String sql=String.format("SELECT * FROM %s WHERE id=? ",getTableName());
        try(PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            resultSet.next();
            return (T) EntityMapper.parseResultSet(resultSet,getTableName());
        }catch ( SQLException e){
            LOGGER.warn(String.format(GET_BY_ID_ERROR_MESSAGE,id),e);
            throw new DaoException(String.format(GET_BY_ID_ERROR_MESSAGE,id),e);
        }
//        for(T entity:repository){
//            if(id.equals(entity.getId())){
//                return entity;
//            }
//        }
//        LOGGER.log(Level.WARNING,String.format(GET_BY_ID_ERROR_MESSAGE,id));
//        throw new DaoException(String.format(GET_BY_ID_ERROR_MESSAGE,id));
    }



    @Override
    public List<T> getByIdList(Integer id) {
        repository1.removeAll(repository1);
        Connection connection=connector.getConnection();
        String sql=String.format("SELECT * FROM %s WHERE id=?",getTableName());
        try(PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            resultSet.next();
            repository1.add((T) EntityMapper.parseResultSet(resultSet,getTableName()));
            return new ArrayList<>(repository1);
        }catch (SQLException e){
            LOGGER.warn(String.format(GET_BY_ID_ERROR_MESSAGE,id));
            throw new DaoException(String.format(GET_BY_ID_ERROR_MESSAGE,id));
        }
//        repository1.removeAll(repository1);
//        for(T entity:repository){
//            if(id.equals(entity.getId())){
//                repository1.add(entity);
//            }
//        }
//        return new ArrayList<>(repository1);
    }

    @Override
    public List<T> getAll() {
        Connection connection=connector.getConnection();
        String sql=String.format("SELECT * FROM %s ",getTableName());
        try(PreparedStatement statement=connection.prepareStatement(sql)){
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                repository.add((T) EntityMapper.parseResultSet(resultSet,getTableName()));
            }
            return new ArrayList<>(repository);
        }catch (SQLException e){
            throw new DaoException(e);
        }
//        return new ArrayList<>(repository);
    }

    @Override
    public void delete(Integer Id) {
        Connection connection=connector.getConnection();
        String sql=String.format("DELETE FROM %s WHERE id=?",getTableName());
        try(PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,Id);
            statement.executeUpdate();
        }catch (SQLException e){
            LOGGER.warn(String.format(GET_BY_ID_ERROR_MESSAGE,Id));
            throw new DaoException(String.format(GET_BY_ID_ERROR_MESSAGE,Id));
        }
//        repository.remove(entity);
    }

    protected abstract String getInsertQuery();

    protected abstract String getUpdateQuery();

    protected abstract void prepareStatementForUpdate(PreparedStatement statement,T entity) throws SQLException;

    protected abstract void prepareStatementForCreate(PreparedStatement statement,T entity) throws SQLException;


    protected abstract String getTableName();

}
