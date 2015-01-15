package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria> implements EntidadBancariaDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public List<SucursalBancaria> findAllSucursalesbyEntidadBancaria(int id) {
        
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT s  FROM sucursalBancaria s WHERE idEntidadBancaria="+id);
            List<SucursalBancaria> ts = query.list();
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
        }
    }


}
