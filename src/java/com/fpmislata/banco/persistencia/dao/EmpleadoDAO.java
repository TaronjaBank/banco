package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Empleado;

public interface EmpleadoDAO extends GenericDAO<Empleado>{
    
    Empleado getFromLogin(String loginEmpleado);
    
}
