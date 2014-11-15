package com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.impl;

import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    Connection connection;

    @Override
    public Connection getConnection() {
        DataSource dataSource;
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            dataSource = (DataSource) context.lookup("jdbc/baseDeDatos");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }

}
