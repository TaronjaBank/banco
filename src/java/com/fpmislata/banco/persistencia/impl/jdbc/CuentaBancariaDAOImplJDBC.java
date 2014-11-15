package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class CuentaBancariaDAOImplJDBC implements CuentaBancariaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    Connection connection;
    PreparedStatement preparedStatement;

    @Override
    public CuentaBancaria get(int idCuentaBancaria) {
        connection = connectionFactory.getConnection();
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        try {
            preparedStatement = connection.prepareStatement("SELECT numeroCuentaBancaria,idEntidadBancaria,idCliente FROM cuentaBancaria WHERE idcuentaBancaria=?");
            preparedStatement.setInt(1, idCuentaBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();
            cuentaBancaria.setIdCuentaBancaria(idCuentaBancaria);
            resultSet.next();
            cuentaBancaria.setNumeroCuentaBancaria(resultSet.getInt("numeroCuentaBancaria"));
            cuentaBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
            cuentaBancaria.setIdCliente(resultSet.getInt("idCliente"));
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cuentaBancaria;
    }

    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO cuentaBancaria VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, cuentaBancaria.getIdCuentaBancaria());
            preparedStatement.setInt(2, cuentaBancaria.getNumeroCuentaBancaria());
            preparedStatement.setInt(3, cuentaBancaria.getIdEntidadBancaria());
            preparedStatement.setInt(4, cuentaBancaria.getIdCliente());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            int idCuentaBancaria = keys.getInt(1);
            connection.close();
            return get(idCuentaBancaria);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public CuentaBancaria update(CuentaBancaria cuentaBancaria) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE cuentaBancaria SET numeroCuentaBancaria=?,idEntidadBancaria=?,idCliente=? WHERE idCuentaBancaria=?");
            preparedStatement.setInt(1, cuentaBancaria.getNumeroCuentaBancaria());
            preparedStatement.setInt(2, cuentaBancaria.getIdEntidadBancaria());
            preparedStatement.setInt(3, cuentaBancaria.getIdCliente());
            preparedStatement.setInt(4, cuentaBancaria.getIdCuentaBancaria());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(cuentaBancaria.getIdCuentaBancaria());
    }

    @Override
    public void delete(int idCuentaBancaria) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM cuentaBancaria WHERE idCuentaBancaria=?");
            preparedStatement.setInt(1, idCuentaBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<CuentaBancaria> findAll() {
        connection = connectionFactory.getConnection();
        CuentaBancaria cuentaBancaria;
        List<CuentaBancaria> listacuentasBancarias = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cuentaBancaria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cuentaBancaria = new CuentaBancaria();
                cuentaBancaria.setIdCuentaBancaria(resultSet.getInt("idCuentaBancaria"));
                cuentaBancaria.setNumeroCuentaBancaria(resultSet.getInt("numeroCuentaBancaria"));
                cuentaBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                cuentaBancaria.setIdCliente(resultSet.getInt("idCliente"));
                listacuentasBancarias.add(cuentaBancaria);
            }
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listacuentasBancarias;
    }

}
