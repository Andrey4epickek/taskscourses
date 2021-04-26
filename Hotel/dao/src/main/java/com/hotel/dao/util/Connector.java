package com.hotel.dao.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Connector {

    private static final Logger logger =Logger.getLogger(Connector.class.getName());
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/hotel?user="+"root"+"&password="+"root";
    private static final String NAME ="root";
    private static final String PASSWORD="root";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static Connector instance;
    private Connection connection;

    private Connector(){
        connect();
    }

    public Connection getConnection(){
        try{
            if(connection==null || connection.isClosed()){
                connect();
            }
            return connection;
        }catch (SQLException e){
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static Connector getInstance(){
        if(instance==null){
            instance=new Connector();
        }
        return instance;
    }

    private void connect(){
        try{
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,NAME,PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e){
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

