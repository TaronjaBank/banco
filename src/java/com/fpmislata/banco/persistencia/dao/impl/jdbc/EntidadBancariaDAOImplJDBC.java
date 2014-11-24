package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        String sql = "SELECT codigoEntidadBancaria,nombreEntidadBancaria,fechaCreacionEntidadBancaria FROM entidadBancaria WHERE identidadBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        EntidadBancaria entidadBancaria = new EntidadBancaria();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            resultSet = preparedStatement.executeQuery();
            entidadBancaria.setIdEntidadBancaria(idEntidadBancaria);
            if (resultSet.next()) {
                entidadBancaria.setCodigoEntidadBancaria(resultSet.getString("codigoEntidadBancaria"));
                entidadBancaria.setNombreEntidadBancaria(resultSet.getString("nombreEntidadBancaria"));
                entidadBancaria.setFechaCreacionEntidadBancaria(resultSet.getDate("fechaCreacionEntidadBancaria"));
            }
            connection.close();
            return entidadBancaria;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        String sql = "INSERT INTO entidadBancaria VALUES (null,?,?,now())";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSetKeys;
        int idEntidadBancaria;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getCodigoEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getNombreEntidadBancaria());
            preparedStatement.executeUpdate();
            resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idEntidadBancaria = resultSetKeys.getInt(1);
            connection.close();
            return get(idEntidadBancaria);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        String sql = "UPDATE entidadBancaria SET codigoEntidadBancaria=?,nombreEntidadBancaria=? WHERE idEntidadBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidadBancaria.getCodigoEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getNombreEntidadBancaria());
            preparedStatement.setInt(3, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();
            connection.close();
            return get(entidadBancaria.getIdEntidadBancaria());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idEntidadBancaria) {
        String sql = "DELETE FROM entidadBancaria WHERE idEntidadBancaria=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {
        String sql = "SELECT * FROM entidadBancaria";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        EntidadBancaria entidadBancaria;
        List<EntidadBancaria> entidadesBancarias = new ArrayList();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setCodigoEntidadBancaria(resultSet.getString("codigoEntidadBancaria"));
                entidadBancaria.setNombreEntidadBancaria(resultSet.getString("nombreEntidadBancaria"));
                entidadBancaria.setFechaCreacionEntidadBancaria(resultSet.getDate("fechaCreacionEntidadBancaria"));
                entidadesBancarias.add(entidadBancaria);
            }
            connection.close();
            return entidadesBancarias;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
