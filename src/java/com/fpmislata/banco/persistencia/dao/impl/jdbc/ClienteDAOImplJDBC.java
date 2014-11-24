package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteDAOImplJDBC implements ClienteDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    Connection connection;
    PreparedStatement preparedStatement;

    @Override
    public Cliente get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente insert(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente update(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
