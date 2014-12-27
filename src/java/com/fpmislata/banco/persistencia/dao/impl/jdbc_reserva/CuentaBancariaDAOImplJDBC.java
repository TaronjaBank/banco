package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
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

    @Override
    public CuentaBancaria get(int idCuentaBancaria) {
        String sql = "SELECT numeroCuentaBancaria,idEntidadBancaria,idCliente FROM cuentaBancaria WHERE idcuentaBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCuentaBancaria);
            resultSet = preparedStatement.executeQuery();
            cuentaBancaria.setIdCuentaBancaria(idCuentaBancaria);
            if (resultSet.next()) {
                cuentaBancaria.setNumeroCuentaBancaria(resultSet.getInt("numeroCuentaBancaria"));
                cuentaBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                cuentaBancaria.setIdCliente(resultSet.getInt("idCliente"));
            } else {
                cuentaBancaria = null;
            }
            connection.close();
            return cuentaBancaria;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) {
        String sql = "INSERT INTO cuentaBancaria VALUES (?,?,?,?)";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSetKeys;
        int idCuentaBancaria;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, cuentaBancaria.getIdCuentaBancaria());
            preparedStatement.setInt(2, cuentaBancaria.getNumeroCuentaBancaria());
            preparedStatement.setInt(3, cuentaBancaria.getIdEntidadBancaria());
            preparedStatement.setInt(4, cuentaBancaria.getIdCliente());
            preparedStatement.executeUpdate();
            resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idCuentaBancaria = resultSetKeys.getInt(1);
            connection.close();
            return get(idCuentaBancaria);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public CuentaBancaria update(CuentaBancaria cuentaBancaria) {
        String sql = "UPDATE cuentaBancaria SET numeroCuentaBancaria=?,idEntidadBancaria=?,idCliente=? WHERE idCuentaBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cuentaBancaria.getNumeroCuentaBancaria());
            preparedStatement.setInt(2, cuentaBancaria.getIdEntidadBancaria());
            preparedStatement.setInt(3, cuentaBancaria.getIdCliente());
            preparedStatement.setInt(4, cuentaBancaria.getIdCuentaBancaria());
            preparedStatement.executeUpdate();
            connection.close();
            return get(cuentaBancaria.getIdCuentaBancaria());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idCuentaBancaria) {
        String sql = "DELETE FROM cuentaBancaria WHERE idCuentaBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCuentaBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<CuentaBancaria> findAll() {
        String sql = "SELECT * FROM cuentaBancaria";
        Connection connection;
        PreparedStatement preparedStatement;
        CuentaBancaria cuentaBancaria;
        List<CuentaBancaria> cuentasBancarias = new ArrayList();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cuentaBancaria = new CuentaBancaria();
                cuentaBancaria.setIdCuentaBancaria(resultSet.getInt("idCuentaBancaria"));
                cuentaBancaria.setNumeroCuentaBancaria(resultSet.getInt("numeroCuentaBancaria"));
                cuentaBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                cuentaBancaria.setIdCliente(resultSet.getInt("idCliente"));
                cuentasBancarias.add(cuentaBancaria);
            }
            connection.close();
            return cuentasBancarias;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
