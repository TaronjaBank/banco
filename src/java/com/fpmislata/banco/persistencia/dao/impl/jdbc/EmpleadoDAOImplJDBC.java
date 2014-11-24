package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoDAOImplJDBC implements EmpleadoDAO {

    @Autowired
    ConnectionFactory connectionFactory;
    Connection connection;
    PreparedStatement preparedStatement;

    @Override
    public Empleado get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado insert(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado update(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
