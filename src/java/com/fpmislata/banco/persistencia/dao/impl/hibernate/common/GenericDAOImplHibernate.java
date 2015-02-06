package com.fpmislata.banco.persistencia.dao.impl.hibernate.common;

import com.fpmislata.banco.persistencia.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolationException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDAOImplHibernate<T> implements GenericDAO<T> {

    SessionFactory sessionFactory;

    public static final Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());

    public GenericDAOImplHibernate() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public T get(int id) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T t = (T) session.get(getEntityClass(), id);
            session.getTransaction().commit();
            return t;
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new BussinessException(cve);

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

    @Override
    public T insert(T t) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            session.save(t);
            session.getTransaction().commit();
            return t;
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new BussinessException(cve);
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

    @Override
    public T update(T t) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            return t;
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new BussinessException(cve);

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

    @Override
    public void delete(int id) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T t = (T) session.get(getEntityClass(), id);
            if (t == null) {
                throw new Exception("Los datos que se intentan borrar no existen");
            }
            session.delete(t);
            session.getTransaction().commit();
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new BussinessException(cve);

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

    @Override
    public List<T> findAll() throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("SELECT t FROM " + getEntityClass().getName() + " t");
            List<T> ts = query.list();
            session.getTransaction().commit();
            return ts;
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Error al hacer rollback", exc);
            }
            throw new BussinessException(cve);

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

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
