package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente>{
    
    Cliente getFromLogin(String loginCliente);
    
}
