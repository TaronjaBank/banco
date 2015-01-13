package com.fpmislata.banco.presentacion.listener.persistencia.migration;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletContextListenerImplDataBase implements ServletContextListener {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @Autowired
    JsonTransformer jsonTransformer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
            AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
            autowireCapableBeanFactory.autowireBean(this);

            InitialContext initCtx = new InitialContext();
            DataSource dataSource = (DataSource) initCtx.lookup("java:comp/env/jdbc/MySQLDS");
            initCtx.close();

            Flyway flyway = new Flyway();
            flyway.setDataSource(dataSource);
            flyway.setLocations("com.fpmislata.banco.persistencia.migration");
            flyway.setEncoding("utf-8");
            flyway.migrate();

        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Base de Datos Actualizada");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("");
    }
}
