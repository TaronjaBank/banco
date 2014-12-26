package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import org.hibernate.Session;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import java.util.List;
import org.hibernate.Query;

public class ClienteDAOImplHibernate implements ClienteDAO {

    @Override
    public Cliente insert(Cliente cliente) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(cliente);

        session.getTransaction().commit();
        session.close();

        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(cliente);

        session.getTransaction().commit();
        session.close();

        return cliente;
    }

    @Override
    public void delete(int idCliente) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(idCliente);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Cliente get(int idCliente) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Cliente cliente = (Cliente) session.get(Cliente.class, idCliente);

        session.getTransaction().commit();
        session.close();

        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT c FROM cliente c");
        List<Cliente> clientes = query.list();

        session.getTransaction().commit();
        session.close();

        return clientes;
    }
    
}
