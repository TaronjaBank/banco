package com.fpmislata.banco.servicio.seguridad;

import com.fpmislata.banco.dominio.Credencial;


public interface GenericAuthentication<T> {
    
    T authenticate(Credencial credencial);
    
}
