package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
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
    Connection connection;
    PreparedStatement preparedStatement;

    @Override
    public MovimientoBancario get(int idMovimientoBancario) {
        connection = connectionFactory.getConnection();
        MovimientoBancario movimientoBancario = new MovimientoBancario();
        try {
            preparedStatement = connection.prepareStatement("SELECT idCuentaBancariaOrigen,idCuentaBancariaDestino,cantidadMovimientoBancario,conceptoMovimientoBancario  FROM movimientoBancario WHERE idmovimientoBancario=?");
            preparedStatement.setInt(1, idMovimientoBancario);
            ResultSet resultSet = preparedStatement.executeQuery();
            movimientoBancario.setIdMovimientoBancario(idMovimientoBancario);
            resultSet.next();
            movimientoBancario.setIdCuentaBancariaOrigen(resultSet.getInt("idCuentaBancariaOrigen"));
            movimientoBancario.setIdCuentaBancariaDestino(resultSet.getInt("idCuentaBancariaDestino"));
            movimientoBancario.setCantidadMovimientoBancario(resultSet.getDouble("cantidadMovimientoBancario"));
            movimientoBancario.setConceptoMovimientoBancario(resultSet.getString("conceptoMovimientoBancario"));

            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return movimientoBancario;
    }

    @Override
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) {
        connection = connectionFactory.getConnection();
        int idMovimientoBancario;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO movimientoBancario VALUES (null,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, movimientoBancario.getIdCuentaBancariaOrigen());
            preparedStatement.setInt(2, movimientoBancario.getIdCuentaBancariaDestino());
            preparedStatement.setDouble(3, movimientoBancario.getCantidadMovimientoBancario());
            preparedStatement.setString(4, movimientoBancario.getConceptoMovimientoBancario());

            preparedStatement.executeUpdate();

            ResultSet resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idMovimientoBancario = resultSetKeys.getInt(1);

            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(idMovimientoBancario);
    }

    @Override
    public MovimientoBancario update(MovimientoBancario movimientoBancario) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE movimientoBancario SET idCuentaBancariaOrigen=?,idCuentaBancariaDestino=?,cantidadMovimientoBancario=?,conceptoMovimientoBancario=? WHERE idMovimientoBancario=?");
            preparedStatement.setInt(5, movimientoBancario.getIdMovimientoBancario());
            preparedStatement.setInt(1, movimientoBancario.getIdCuentaBancariaOrigen());
            preparedStatement.setInt(2, movimientoBancario.getIdCuentaBancariaDestino());
            preparedStatement.setDouble(3, movimientoBancario.getCantidadMovimientoBancario());
            preparedStatement.setString(4, movimientoBancario.getConceptoMovimientoBancario());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return get(movimientoBancario.getIdMovimientoBancario());
    }

    @Override
    public void delete(int idMovimientoBancario) {
        connection = connectionFactory.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM movimientoBancario WHERE idMovimientoBancario=?");
            preparedStatement.setInt(1, idMovimientoBancario);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<MovimientoBancario> findAll() {
        connection = connectionFactory.getConnection();
        MovimientoBancario movimientoBancario;
        List<MovimientoBancario> listamovimientosBancarios = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM movimientoBancario");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movimientoBancario = new MovimientoBancario();
                movimientoBancario.setIdMovimientoBancario(resultSet.getInt("idMovimientoBancario"));
                movimientoBancario.setIdCuentaBancariaOrigen(resultSet.getInt("idCuentaBancariaOrigen"));
                movimientoBancario.setIdCuentaBancariaDestino(resultSet.getInt("idCuentaBancariaDestino"));
                movimientoBancario.setCantidadMovimientoBancario(resultSet.getDouble("cantidadMovimientoBancario"));
                movimientoBancario.setConceptoMovimientoBancario(resultSet.getString("conceptoMovimientoBancario"));
                listamovimientosBancarios.add(movimientoBancario);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return listamovimientosBancarios;
    }
}
