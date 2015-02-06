package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class ClienteDAOImplHibernate extends GenericDAOImplHibernate<Cliente> implements ClienteDAO {

    @Override
    public Cliente getFromLogin(String loginCliente) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT c FROM Cliente c WHERE loginCliente=:loginCliente");
        query.setParameter("loginCliente", loginCliente);
        Cliente cliente = (Cliente) query.uniqueResult();
        session.getTransaction().commit();
        
        return cliente;
    }
    
}
