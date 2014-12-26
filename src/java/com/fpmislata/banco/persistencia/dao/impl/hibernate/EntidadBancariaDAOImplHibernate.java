package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import java.util.List;
import org.hibernate.Query;

public class EntidadBancariaDAOImplHibernate implements EntidadBancariaDAO {

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(entidadBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return entidadBancaria;
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(entidadBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return entidadBancaria;
    }

    @Override
    public void delete(int idEntidadBancaria) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(idEntidadBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();
    }

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        EntidadBancaria entidadBancaria = (EntidadBancaria) session.get(EntidadBancaria.class, idEntidadBancaria);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return entidadBancaria;
    }

    @Override
    public List<EntidadBancaria> findAll() {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT eb FROM entidadbancaria eb");
        List<EntidadBancaria> entidadesBancarias = query.list();
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return entidadesBancarias;
    }
    
}
