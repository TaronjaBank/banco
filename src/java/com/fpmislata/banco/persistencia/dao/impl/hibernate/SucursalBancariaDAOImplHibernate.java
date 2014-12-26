package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
import java.util.List;
import org.hibernate.Query;

public class SucursalBancariaDAOImplHibernate implements SucursalBancariaDAO {

    @Override
    public SucursalBancaria insert(SucursalBancaria sucursalBancaria) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(sucursalBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return sucursalBancaria;
    }

    @Override
    public SucursalBancaria update(SucursalBancaria sucursalBancaria) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(sucursalBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return sucursalBancaria;
    }

    @Override
    public void delete(int idSucursalBancaria) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(idSucursalBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();
    }

    @Override
    public SucursalBancaria get(int idSucursalBancaria) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        SucursalBancaria sucursalBancaria = (SucursalBancaria) session.get(SucursalBancaria.class, idSucursalBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return sucursalBancaria;
    }

    @Override
    public List<SucursalBancaria> findAll() {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT sb FROM sucursalbancaria sb");
        List<SucursalBancaria> sucursalesBancarias = query.list();
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return sucursalesBancarias;
    }
    
}
