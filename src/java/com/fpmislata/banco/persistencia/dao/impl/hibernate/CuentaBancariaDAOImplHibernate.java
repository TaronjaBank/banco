package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import java.util.List;
import org.hibernate.Query;

public class CuentaBancariaDAOImplHibernate implements CuentaBancariaDAO {

    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(cuentaBancaria);

        session.getTransaction().commit();
        session.close();

        return cuentaBancaria;
    }

    @Override
    public CuentaBancaria update(CuentaBancaria cuentaBancaria) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.update(cuentaBancaria);

        session.getTransaction().commit();
        session.close();

        return cuentaBancaria;
    }

    @Override
    public void delete(int idCuentaBancaria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.delete(idCuentaBancaria);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CuentaBancaria get(int idCuentaBancaria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        CuentaBancaria cuentaBancaria = (CuentaBancaria) session.get(CuentaBancaria.class, idCuentaBancaria);

        session.getTransaction().commit();
        session.close();

        return cuentaBancaria;
    }

    @Override
    public List<CuentaBancaria> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();

        Query query = session.createQuery("SELECT cb FROM cuentabancaria cb");
        List<CuentaBancaria> cuentasBancarias = query.list();

        session.getTransaction().commit();
        session.close();

        return cuentasBancarias;
    }
    
}
