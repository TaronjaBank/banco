package com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.impl;

import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        DataSource dataSource;
        Connection connection;
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            dataSource = (DataSource) context.lookup("jdbc/baseDeDatos");
            connection = dataSource.getConnection();
            return connection;
        } catch (NamingException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
