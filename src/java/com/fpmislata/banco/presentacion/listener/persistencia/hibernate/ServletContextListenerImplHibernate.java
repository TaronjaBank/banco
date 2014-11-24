package com.fpmislata.banco.presentacion.listener.persistencia.hibernate;

import com.fpmislata.banco.persistencia.dao.impl.hibernate.HibernateUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImplHibernate implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.buildSessionFactory();
    }
    
}
