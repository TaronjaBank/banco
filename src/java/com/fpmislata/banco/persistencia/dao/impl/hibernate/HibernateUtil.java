package com.fpmislata.banco.persistencia.dao.impl.hibernate;

public class HibernateUtil {
    
    public static synchronized void buildSessionFactory() {
        System.out.println("Hibernate Arrancado.");
    }

    public static synchronized void closeSessionFactory() {
        System.out.println("Hibernate Parado.");
    }
    
}
