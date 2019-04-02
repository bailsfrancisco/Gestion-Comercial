package ar.com.gestioncomercial.controller;

import java.util.List;

public interface CrudController<T> {

    void create( T entity);

    T retrieve(T entity);

    T retrievebyId(Long id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();
}
