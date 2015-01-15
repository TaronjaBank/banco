package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria> implements EntidadBancariaDAO {
    SessionFactory sessionFactory;
    public List<EntidadBancaria> findAllSucursalesbyEntidadBancaria(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT * FROM sucursalBancaria WHERE idEntidadBancaria="+id);
            List<EntidadBancaria> ts = query.list();
            session.getTransaction().commit();
            return ts;
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }


}
