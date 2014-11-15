package com.fpmislata.banco.persistencia.impl.jdbc;
import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
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
    PreparedStatement preparedStatement;
    Connection connection;
    
    
    @Override
    public SucursalBancaria get(int idSucursalBancaria) {
         connection = connectionFactory.getConnection();
        SucursalBancaria sucursalBancaria = new SucursalBancaria();
        try {
            preparedStatement = connection.prepareStatement("SELECT nombreSucursalBancaria, direccionSucursalBancaria, idEntidadBancaria FROM sucursalBancaria WHERE idSucursalBancaria=?");
            preparedStatement.setInt(1, idSucursalBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();
            sucursalBancaria.setIdSucursalBancaria(idSucursalBancaria);
            resultSet.next();
            sucursalBancaria.setNombreSucursalBancaria(resultSet.getString("nombreSucursalBancaria"));
            sucursalBancaria.setDireccionSucursalBancaria(resultSet.getString("direccionSucursalBancaria"));
            sucursalBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return sucursalBancaria;
    }
    
    @Override
    public SucursalBancaria insert(SucursalBancaria sucursalBancaria) {
        int idSucursalBancaria;
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO sucursalBancaria VALUES (null,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, sucursalBancaria.getNombreSucursalBancaria());
            preparedStatement.setString(2, sucursalBancaria.getDireccionSucursalBancaria());
            preparedStatement.setInt(3, sucursalBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();
            
            ResultSet resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idSucursalBancaria = resultSetKeys.getInt(1);
            
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(idSucursalBancaria);
    }
    
    @Override
    public SucursalBancaria update(SucursalBancaria sucursalBancaria) {
         connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE sucursalBancaria SET nombreSucursalBancaria=?,direccionSucursalBancaria=?, idEntidadBancaria=? WHERE idSucursalBancaria=?");
            preparedStatement.setString(1, sucursalBancaria.getNombreSucursalBancaria());
            preparedStatement.setString(2, sucursalBancaria.getDireccionSucursalBancaria());
            preparedStatement.setInt(3, sucursalBancaria.getIdEntidadBancaria());
            preparedStatement.setInt(4, sucursalBancaria.getIdSucursalBancaria());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(sucursalBancaria.getIdSucursalBancaria());
    }
    
    @Override
    public void delete(int idSucursalBancaria) {
         connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM sucursalBancaria WHERE idSucursalBancaria=?");
            preparedStatement.setInt(1, idSucursalBancaria);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    

    @Override
    public List<SucursalBancaria> findAll() {
         connection = connectionFactory.getConnection();
        SucursalBancaria sucursalBancaria;
        List<SucursalBancaria> listaSucursalesBancarias = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM sucursalBancaria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sucursalBancaria = new SucursalBancaria();
                sucursalBancaria.setIdSucursalBancaria(resultSet.getInt("idSucursalBancaria"));
                sucursalBancaria.setNombreSucursalBancaria(resultSet.getString("nombreSucursalBancaria"));
                sucursalBancaria.setDireccionSucursalBancaria(resultSet.getString("direccionSucursalBancaria"));
                sucursalBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                listaSucursalesBancarias.add(sucursalBancaria);
                
            }
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listaSucursalesBancarias;
    }
}
