package com.fpmislata.banco.persistencia.dao;

import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.BussinessException;
import java.util.List;

public interface GenericDAO<T> {
    T get(int id) throws BussinessException;
    T insert(T t) throws BussinessException;
    T update(T t) throws BussinessException;
    void delete(int id) throws BussinessException;
    List<T> findAll() throws BussinessException;
}
