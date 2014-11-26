package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.persistencia.dao.impl.jdbc.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoDAOImplJDBC implements EmpleadoDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Empleado get(int idEmpleado) {
        String sql = "SELECT * FROM empleado WHERE idEmpleado=?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Empleado empleado = new Empleado();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEmpleado);
            resultSet = preparedStatement.executeQuery();
            empleado.setIdEmpleado(idEmpleado);
            if (resultSet.next()) {
                empleado.setIdEmpleado(idEmpleado);
                empleado.setDniEmpleado(resultSet.getString("dniEmpleado"));
                empleado.setNombreEmpleado(resultSet.getString("nombreEmpleado"));
                empleado.setApellido1Empleado(resultSet.getString("apellido1Empleado"));
                empleado.setApellido2Empleado(resultSet.getString("apellido2Empleado"));
                empleado.setIdSucursalBancaria(resultSet.getInt("idSucursalBancaria"));
                empleado.setLogin(resultSet.getString("loginEmpleado"));
                empleado.setPassword(resultSet.getString("passwordEmpleado"));
            } else {
                empleado = null;
            }
            connection.close();
            return empleado;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Empleado getFromLogin(String loginEmpleado) {
        String sql = "SELECT * FROM empleado WHERE loginEmpleado=?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Empleado empleado = new Empleado();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginEmpleado);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setDniEmpleado(resultSet.getString("dniEmpleado"));
                empleado.setNombreEmpleado(resultSet.getString("nombreEmpleado"));
                empleado.setApellido1Empleado(resultSet.getString("apellido1Empleado"));
                empleado.setApellido2Empleado(resultSet.getString("apellido2Empleado"));
                empleado.setIdSucursalBancaria(resultSet.getInt("idSucursalBancaria"));
                empleado.setLogin(loginEmpleado);
                empleado.setPassword(resultSet.getString("passwordEmpleado"));
            } else {
                empleado = null;
            }
            connection.close();
            return empleado;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Empleado insert(Empleado empleado) {
        String sql = "INSERT INTO empleado VALUES(null,?,?,?,?,?)";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSetKeys;
        int idEmpleado;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, empleado.getDniEmpleado());
            preparedStatement.setString(2, empleado.getNombreEmpleado());
            preparedStatement.setString(3, empleado.getApellido1Empleado());
            preparedStatement.setString(4, empleado.getApellido2Empleado());
            preparedStatement.setInt(5, empleado.getIdSucursalBancaria());
            preparedStatement.executeUpdate();
            resultSetKeys = preparedStatement.getGeneratedKeys();
            resultSetKeys.next();
            idEmpleado = resultSetKeys.getInt(1);
            connection.close();
            return get(idEmpleado);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Empleado update(Empleado empleado) {
        String sql = "UPDATE empleado SET dniEmpleado=?,nombreEmpleado=?,apellido1Empleado=?,apellido2Empleado=?,idSucursalBancaria=? WHERE idEmpleado=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empleado.getDniEmpleado());
            preparedStatement.setString(2, empleado.getNombreEmpleado());
            preparedStatement.setString(3, empleado.getApellido1Empleado());
            preparedStatement.setString(4, empleado.getApellido2Empleado());
            preparedStatement.setInt(5, empleado.getIdSucursalBancaria());
            preparedStatement.setInt(6, empleado.getIdEmpleado());
            preparedStatement.executeUpdate();
            connection.close();
            return get(empleado.getIdEmpleado());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int idEmpleado) {
        String sql = "DELETE FROM empleado WHERE idEmpleado=?";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Empleado> findAll() {
        String sql = "SELECT * FROM empleado";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Empleado empleado;
        List<Empleado> empleados = new ArrayList();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setDniEmpleado(resultSet.getString("dniEmpleado"));
                empleado.setNombreEmpleado(resultSet.getString("nombreEmpleado"));
                empleado.setApellido1Empleado(resultSet.getString("apellido1Empleado"));
                empleado.setApellido2Empleado(resultSet.getString("apellido2Empleado"));
                empleado.setIdSucursalBancaria(resultSet.getInt("idSucursalBancaria"));
                empleados.add(empleado);
            }
            connection.close();
            return empleados;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
