package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
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
    Connection connection;
    PreparedStatement preparedStatement;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        connection = connectionFactory.getConnection();
        EntidadBancaria entidadBancaria = new EntidadBancaria();
        try {
            preparedStatement = connection.prepareStatement("SELECT codigoEntidadBancaria,nombreEntidadBancaria,fechaCreacionEntidadBancaria FROM entidadBancaria WHERE identidadBancaria=?");
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();
            entidadBancaria.setIdEntidadBancaria(idEntidadBancaria);
            resultSet.next();
            entidadBancaria.setCodigoEntidadBancaria(resultSet.getString("codigoEntidadBancaria"));
            entidadBancaria.setNombreEntidadBancaria(resultSet.getString("nombreEntidadBancaria"));
            entidadBancaria.setFechaCreacionEntidadBancaria(resultSet.getDate("fechaCreacionEntidadBancaria"));
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entidadBancaria;
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        connection = connectionFactory.getConnection();
        int idEntidadBancaria;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO entidadBancaria VALUES (null,?,?,now())",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getCodigoEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getNombreEntidadBancaria());

            preparedStatement.executeUpdate();

            ResultSet resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idEntidadBancaria = resultSetKeys.getInt(1);

            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(idEntidadBancaria);
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE entidadBancaria SET codigoEntidadBancaria=?,nombreEntidadBancaria=? WHERE idEntidadBancaria=?");
            preparedStatement.setString(1, entidadBancaria.getCodigoEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getNombreEntidadBancaria());

            preparedStatement.setInt(3, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(entidadBancaria.getIdEntidadBancaria());
    }

    @Override
    public void delete(int idEntidadBancaria) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM entidadBancaria WHERE idEntidadBancaria=?");
            preparedStatement.setInt(1, idEntidadBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {
        connection = connectionFactory.getConnection();
        EntidadBancaria entidadBancaria;
        List<EntidadBancaria> listaentidadesBancarias = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM entidadBancaria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setCodigoEntidadBancaria(resultSet.getString("codigoEntidadBancaria"));
                entidadBancaria.setNombreEntidadBancaria(resultSet.getString("nombreEntidadBancaria"));
                entidadBancaria.setFechaCreacionEntidadBancaria(resultSet.getDate("fechaCreacionEntidadBancaria"));
                listaentidadesBancarias.add(entidadBancaria);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listaentidadesBancarias;
    }

}
