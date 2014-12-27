package com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory;

import java.sql.Connection;

public interface ConnectionFactory {

    public abstract Connection getConnection();
}
