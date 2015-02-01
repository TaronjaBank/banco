package com.fpmislata.banco.servicio.seguridad.impl;

import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.dominio.Credencial;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import com.fpmislata.banco.servicio.seguridad.ClienteAuthentication;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteAuthenticationImplDataBase implements ClienteAuthentication{
    
    @Autowired
    ClienteDAO clienteDAO;
    
    @Override
    public Cliente authenticate(Credencial credencial) {
        Cliente cliente = clienteDAO.getFromLogin(credencial.getLogin());
        if(cliente != null){
            if(!credencial.getPassword().equals(cliente.getPasswordCliente())){
                cliente = null;
            }
        }
        return cliente;
    }
    
}
