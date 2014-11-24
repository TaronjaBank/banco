package com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.impl;

import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import com.fpmislata.banco.persistencia.datasourcefactory.DataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Autowired
    DataSourceFactory dataSourceFactory;
    
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            DataSource dataSource = dataSourceFactory.getDataSource("java:comp/env", "jdbc/baseDeDatos");
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }
}
