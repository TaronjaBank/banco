package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.dominio.SucursalBancaria;
import java.util.List;

public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria>{
public List<SucursalBancaria> findAllSucursalesbyEntidadBancaria(int id);
}
