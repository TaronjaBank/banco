package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import java.util.List;
import org.hibernate.Query;

public class MovimientoBancarioDAOImplHibernate implements MovimientoBancarioDAO {

    @Override
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(movimientoBancario);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return movimientoBancario;
    }

    @Override
    public MovimientoBancario update(MovimientoBancario movimientoBancario) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(movimientoBancario);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return movimientoBancario;
    }

    @Override
    public void delete(int idMovimientoBancario) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        MovimientoBancario movimientoBancario = (MovimientoBancario) session.get(MovimientoBancario.class, idMovimientoBancario);
        session.delete(movimientoBancario);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();
    }

    @Override
    public MovimientoBancario get(int idMovimientoBancario) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        MovimientoBancario movimientoBancario = (MovimientoBancario) session.get(MovimientoBancario.class, idMovimientoBancario);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return movimientoBancario;
    }

    @Override
    public List<MovimientoBancario> findAll() {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT mb FROM MovimientoBancario mb");
        List<MovimientoBancario> movimientosBancarios = query.list();
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return movimientosBancarios;
    }
    
}
