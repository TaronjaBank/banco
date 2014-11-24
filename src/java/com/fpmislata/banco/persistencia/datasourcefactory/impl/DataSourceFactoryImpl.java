package com.fpmislata.banco.persistencia.datasourcefactory.impl;

import com.fpmislata.banco.persistencia.datasourcefactory.DataSourceFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDataSource(String contexto, String dataSourceName) {
        InitialContext initialContext;
        Context context;
        DataSource dataSource;
        try {
            initialContext = new InitialContext();
            context = (Context) initialContext.lookup(contexto);
            dataSource = (DataSource) context.lookup(dataSourceName);
            return dataSource;
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
