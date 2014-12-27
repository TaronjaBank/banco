package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import java.util.List;
import org.hibernate.Query;

public class EmpleadoDAOImplHibernate implements EmpleadoDAO {

    @Override
    public Empleado insert(Empleado empleado) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(empleado);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return empleado;
    }

    @Override
    public Empleado update(Empleado empleado) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(empleado);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return empleado;
    }

    @Override
    public void delete(int idEmpleado) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);
        session.delete(empleado);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();
    }

    @Override
    public Empleado get(int idEmpleado) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return empleado;
    }

    @Override
    public Empleado getFromLogin(String loginEmpleado) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Empleado empleado = (Empleado) session.get(Empleado.class, loginEmpleado);
        //El problema es que busca en base a la PK y loginEmpleado no es PK de la tabla empleado
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return empleado;
    }

    @Override
    public List<Empleado> findAll() {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT e FROM Empleado e");
        List<Empleado> empleados = query.list();
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return empleados;
    }

}
