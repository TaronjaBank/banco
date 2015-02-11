package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.BussinessException;

public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria>{ 
    
    CuentaBancaria getFromNumeroCuenta(String numeroCuenta) throws BussinessException;
}
