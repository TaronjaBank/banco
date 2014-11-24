
package com.fpmislata.banco.persistencia.datasourcefactory;

import javax.sql.DataSource;

public interface DataSourceFactory {
    
    public DataSource getDataSource(String contexto, String dataSourceName);
    
}
