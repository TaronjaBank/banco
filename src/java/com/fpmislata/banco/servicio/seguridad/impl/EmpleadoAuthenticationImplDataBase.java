package com.fpmislata.banco.servicio.seguridad.impl;

import com.fpmislata.banco.dominio.Credencial;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.servicio.seguridad.EmpleadoAuthentication;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoAuthenticationImplDataBase implements EmpleadoAuthentication {

    @Autowired
    EmpleadoDAO empleadoDAO;

    @Override
    public Empleado authenticate(Credencial credencial) {

        Empleado empleado = empleadoDAO.getFromLogin(credencial.getLogin());
        return empleado;
        
    }

}
