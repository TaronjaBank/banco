package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.BussinessException;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.GenericDAOImplHibernate;

public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria> implements EntidadBancariaDAO {

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) throws BussinessException {
        
        if(entidadBancaria.getCodigoEntidadBancaria().length()!=5){
            throw new BussinessException("codigoLength","El codigo de la Entidad Bancaria debe tener 5 caracteres.");
        }
        
        return super.insert(entidadBancaria);
        
    }


    
}
