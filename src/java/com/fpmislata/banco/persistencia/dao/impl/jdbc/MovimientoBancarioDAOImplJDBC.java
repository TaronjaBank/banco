package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MovimientoBancarioDAOImplJDBC implements MovimientoBancarioDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public MovimientoBancario get(int idMovimientoBancario) {
        String sql = "SELECT idCuentaBancariaOrigen,idCuentaBancariaDestino,cantidadMovimientoBancario,conceptoMovimientoBancario FROM movimientoBancario WHERE idmovimientoBancario=?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        MovimientoBancario movimientoBancario = new MovimientoBancario();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMovimientoBancario);
            resultSet = preparedStatement.executeQuery();
            movimientoBancario.setIdMovimientoBancario(idMovimientoBancario);
            if (resultSet.next()) {
                movimientoBancario.setIdCuentaBancariaOrigen(resultSet.getInt("idCuentaBancariaOrigen"));
                movimientoBancario.setIdCuentaBancariaDestino(resultSet.getInt("idCuentaBancariaDestino"));
                movimientoBancario.setCantidadMovimientoBancario(resultSet.getDouble("cantidadMovimientoBancario"));
                movimientoBancario.setConceptoMovimientoBancario(resultSet.getString("conceptoMovimientoBancario"));
            } else {
                movimientoBancario = null;
            }
            connection.close();
            return movimientoBancario;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) {
        String sql = "INSERT INTO movimientoBancario VALUES (null,?,?,?,?)";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSetKeys;
        int idNewMovimientoBancario;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, movimientoBancario.getIdCuentaBancariaOrigen());
            preparedStatement.setInt(2, movimientoBancario.getIdCuentaBancariaDestino());
            preparedStatement.setDouble(3, movimientoBancario.getCantidadMovimientoBancario());
            preparedStatement.setString(4, movimientoBancario.getConceptoMovimientoBancario());
            preparedStatement.executeUpdate();
            resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idNewMovimientoBancario = resultSetKeys.getInt(1);
            connection.close();
            return get(idNewMovimientoBancario);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public MovimientoBancario update(MovimientoBancario movimientoBancario) {
        String sql = "UPDATE movimientoBancario SET idCuentaBancariaOrigen=?,idCuentaBancariaDestino=?,cantidadMovimientoBancario=?,conceptoMovimientoBancario=? WHERE idMovimientoBancario=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(5, movimientoBancario.getIdMovimientoBancario());
            preparedStatement.setInt(1, movimientoBancario.getIdCuentaBancariaOrigen());
            preparedStatement.setInt(2, movimientoBancario.getIdCuentaBancariaDestino());
            preparedStatement.setDouble(3, movimientoBancario.getCantidadMovimientoBancario());
            preparedStatement.setString(4, movimientoBancario.getConceptoMovimientoBancario());
            preparedStatement.executeUpdate();
            connection.close();
            return get(movimientoBancario.getIdMovimientoBancario());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idMovimientoBancario) {
        String sql = "DELETE FROM movimientoBancario WHERE idMovimientoBancario=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMovimientoBancario);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<MovimientoBancario> findAll() {
        String sql = "SELECT * FROM movimientoBancario";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        MovimientoBancario movimientoBancario;
        List<MovimientoBancario> movimientosBancarios = new ArrayList();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movimientoBancario = new MovimientoBancario();
                movimientoBancario.setIdMovimientoBancario(resultSet.getInt("idMovimientoBancario"));
                movimientoBancario.setIdCuentaBancariaOrigen(resultSet.getInt("idCuentaBancariaOrigen"));
                movimientoBancario.setIdCuentaBancariaDestino(resultSet.getInt("idCuentaBancariaDestino"));
                movimientoBancario.setCantidadMovimientoBancario(resultSet.getDouble("cantidadMovimientoBancario"));
                movimientoBancario.setConceptoMovimientoBancario(resultSet.getString("conceptoMovimientoBancario"));
                movimientosBancarios.add(movimientoBancario);
            }
            connection.close();
            return movimientosBancarios;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
