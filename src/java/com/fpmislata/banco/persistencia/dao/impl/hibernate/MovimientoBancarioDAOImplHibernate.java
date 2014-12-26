package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import java.util.List;
import org.hibernate.Query;

public class MovimientoBancarioDAOImplHibernate implements MovimientoBancarioDAO {

    @Override
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(movimientoBancario);

        session.getTransaction().commit();
        session.close();

        return movimientoBancario;
    }

    @Override
    public MovimientoBancario update(MovimientoBancario movimientoBancario) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(movimientoBancario);

        session.getTransaction().commit();
        session.close();

        return movimientoBancario;
    }

    @Override
    public void delete(int idMovimientoBancario) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(idMovimientoBancario);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public MovimientoBancario get(int idMovimientoBancario) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        MovimientoBancario movimientoBancario = (MovimientoBancario) session.get(MovimientoBancario.class, idMovimientoBancario);

        session.getTransaction().commit();
        session.close();

        return movimientoBancario;
    }

    @Override
    public List<MovimientoBancario> findAll() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT mb FROM movimientobancario mb");
        List<MovimientoBancario> movimientosBancarios = query.list();

        session.getTransaction().commit();
        session.close();

        return movimientosBancarios;
    }
    
}
