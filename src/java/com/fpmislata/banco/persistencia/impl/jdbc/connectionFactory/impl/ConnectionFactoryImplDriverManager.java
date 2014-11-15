package com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.impl;

import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImplDriverManager implements ConnectionFactory {

    Connection connection;

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "pruebabanco", "root", "root");
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }
}
