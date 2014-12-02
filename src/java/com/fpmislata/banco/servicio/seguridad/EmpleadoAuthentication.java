package com.fpmislata.banco.servicio.seguridad;

import com.fpmislata.banco.dominio.Credencial;
import com.fpmislata.banco.dominio.Empleado;

public interface EmpleadoAuthentication {
    
    public Empleado authenticate(Credencial credencial);
    
}
