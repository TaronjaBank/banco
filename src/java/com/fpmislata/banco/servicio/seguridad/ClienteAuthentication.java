package com.fpmislata.banco.servicio.seguridad;

import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.dominio.Credencial;

public interface ClienteAuthentication {
    
    public Cliente authenticate(Credencial credencial);
    
}
