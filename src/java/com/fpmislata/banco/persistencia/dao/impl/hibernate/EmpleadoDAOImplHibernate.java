package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.Query;

public class EmpleadoDAOImplHibernate implements EmpleadoDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Empleado insert(Empleado empleado) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(empleado);

        session.getTransaction().commit();
        session.close();

        return empleado;
    }

    @Override
    public Empleado update(Empleado empleado) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(empleado);

        session.getTransaction().commit();
        session.close();

        return empleado;
    }

    @Override
    public void delete(int idEmpleado) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(idEmpleado);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Empleado get(int idEmpleado) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);

        session.getTransaction().commit();
        session.close();

        return empleado;
    }

    @Override
    public Empleado getFromLogin(String loginEmpleado) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Empleado empleado = (Empleado) session.get(Empleado.class, loginEmpleado);

        session.getTransaction().commit();
        session.close();
        
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        Empleado empleado;
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();

        Query query = session.createQuery("SELECT e FROM Empleado e");
        List<Empleado> empleados = query.list();

        session.getTransaction().commit();
        session.close();

        return empleados;
    }
    
}
