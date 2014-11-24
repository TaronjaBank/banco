package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SucursalBancariaDAOImplJDBC implements SucursalBancariaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public SucursalBancaria get(int idSucursalBancaria) {
        String sql = "SELECT nombreSucursalBancaria, direccionSucursalBancaria, idEntidadBancaria FROM sucursalbancaria WHERE idSucursalBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        SucursalBancaria sucursalBancaria = new SucursalBancaria();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idSucursalBancaria);
            resultSet = preparedStatement.executeQuery();
            sucursalBancaria.setIdSucursalBancaria(idSucursalBancaria);
            if (resultSet.next()) {
                sucursalBancaria.setNombreSucursalBancaria(resultSet.getString("nombreSucursalBancaria"));
                sucursalBancaria.setDireccionSucursalBancaria(resultSet.getString("direccionSucursalBancaria"));
                sucursalBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
            }
            connection.close();
            return sucursalBancaria;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public SucursalBancaria insert(SucursalBancaria sucursalBancaria) {
        String sql = "INSERT INTO sucursalbancaria VALUES (null,?,?,?)";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSetKeys;
        int idSucursalBancaria;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, sucursalBancaria.getNombreSucursalBancaria());
            preparedStatement.setString(2, sucursalBancaria.getDireccionSucursalBancaria());
            preparedStatement.setInt(3, sucursalBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();
            resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idSucursalBancaria = resultSetKeys.getInt(1);
            connection.close();
            return get(idSucursalBancaria);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public SucursalBancaria update(SucursalBancaria sucursalBancaria) {
        String sql = "UPDATE sucursalbancaria SET nombreSucursalBancaria=?,direccionSucursalBancaria=?, idEntidadBancaria=? WHERE idSucursalBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sucursalBancaria.getNombreSucursalBancaria());
            preparedStatement.setString(2, sucursalBancaria.getDireccionSucursalBancaria());
            preparedStatement.setInt(3, sucursalBancaria.getIdEntidadBancaria());
            preparedStatement.setInt(4, sucursalBancaria.getIdSucursalBancaria());
            preparedStatement.executeUpdate();
            connection.close();
            return get(sucursalBancaria.getIdSucursalBancaria());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idSucursalBancaria) {
        String sql = "DELETE FROM sucursalbancaria WHERE idSucursalBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idSucursalBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<SucursalBancaria> findAll() {
        String sql = "SELECT * FROM sucursalbancaria";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        SucursalBancaria sucursalBancaria;
        List<SucursalBancaria> sucursalesBancarias = new ArrayList();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sucursalBancaria = new SucursalBancaria();
                sucursalBancaria.setIdSucursalBancaria(resultSet.getInt("idSucursalBancaria"));
                sucursalBancaria.setNombreSucursalBancaria(resultSet.getString("nombreSucursalBancaria"));
                sucursalBancaria.setDireccionSucursalBancaria(resultSet.getString("direccionSucursalBancaria"));
                sucursalBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                sucursalesBancarias.add(sucursalBancaria);
            }
            connection.close();
            return sucursalesBancarias;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
