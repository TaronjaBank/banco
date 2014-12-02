package com.fpmislata.banco.persistencia.dao;

import java.util.List;

public interface GenericDAO<T> {
    T get(int id);
    T insert(T t);
    T update(T t);
    void delete(int id);
    List<T> findAll();
}
