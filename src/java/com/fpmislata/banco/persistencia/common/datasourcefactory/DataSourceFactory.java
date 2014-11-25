
package com.fpmislata.banco.persistencia.common.datasourcefactory;

import javax.sql.DataSource;

public interface DataSourceFactory {
    
    public DataSource getDataSource(String contexto, String dataSourceName);
    
}
