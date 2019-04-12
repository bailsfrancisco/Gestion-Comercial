package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.CategoriaDAO;
import ar.com.gestioncomercial.controller.CategoriaController;
import ar.com.gestioncomercial.model.Categoria;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoriaControllerImpl implements CategoriaController {

    @EJB
    private CategoriaDAO categoriaDAO;

    @Override
    public void create(Categoria entity) {
        categoriaDAO.create(entity);
    }

    @Override
    public Categoria retrieve(Categoria entity) {
        return null;
    }

    @Override
    public Categoria retrievebyId(Long id) {
        return categoriaDAO.find(id);
    }

    @Override
    public void update(Categoria entity) {
        categoriaDAO.update(entity);
    }

    @Override
    public void delete(Categoria entity) {
        categoriaDAO.delete(entity);
    }

    @Override
    public List<Categoria> getAll() {
        return categoriaDAO.getAllCategorias();
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
}
