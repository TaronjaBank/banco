package com.fpmislata.banco.servicio.seguridad.impl;

import com.fpmislata.banco.dominio.Credencial;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.servicio.seguridad.EmpleadoAuthentication;

public class EmpleadoAuthenticationImplDataBase implements EmpleadoAuthentication{

    @Override
    public Empleado authenticate(Credencial credencial) {
        Empleado empleado = new Empleado();
        
        return empleado;
        
    }
    
}
