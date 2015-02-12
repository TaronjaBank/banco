package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.CuentaBancaria;

public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria>{ 
    
    CuentaBancaria getFromNumeroCuenta(String numeroCuenta) throws BussinessException;
}
