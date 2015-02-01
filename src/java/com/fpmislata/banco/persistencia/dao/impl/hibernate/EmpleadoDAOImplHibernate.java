package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class EmpleadoDAOImplHibernate extends GenericDAOImplHibernate<Empleado> implements EmpleadoDAO {

    @Override
    public Empleado getFromLogin(String loginEmpleado) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT e FROM Empleado e where loginEmpleado=:loginEmpleado");
        query.setParameter("loginEmpleado",loginEmpleado);
        Empleado empleado =(Empleado) query.uniqueResult();
        session.getTransaction().commit();

        return empleado;
    }

}

