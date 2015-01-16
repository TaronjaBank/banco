package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.dominio.SucursalBancaria;
import java.util.Set;

public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria>{
public Set<SucursalBancaria> findAllSucursalesbyEntidadBancaria(int id);
}
