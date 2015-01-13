package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.HibernateUtil;
import org.hibernate.Session;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;

public class EmpleadoDAOImplHibernate extends GenericDAOImplHibernate<Empleado> implements EmpleadoDAO {

    @Override
    public Empleado getFromLogin(String loginEmpleado) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Empleado empleado = (Empleado) session.get(Empleado.class, loginEmpleado);
        session.getTransaction().commit();

        return empleado;
    }

}

