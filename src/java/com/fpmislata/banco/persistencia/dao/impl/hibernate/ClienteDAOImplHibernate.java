package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import java.util.List;
import org.hibernate.Query;

public class ClienteDAOImplHibernate implements ClienteDAO {

    @Override
    public Cliente insert(Cliente cliente) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {

        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(cliente);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return cliente;
    }

    @Override
    public void delete(int idCliente) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, idCliente);
        session.delete(cliente);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();
    }

    @Override
    public Cliente get(int idCliente) {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, idCliente);
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        
        HibernateUtil.openSessionAndBindToThread();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT c FROM Cliente c");
        List<Cliente> clientes = query.list();
        session.getTransaction().commit();

        HibernateUtil.closeSessionAndUnbindFromThread();

        return clientes;
    }
    
}
