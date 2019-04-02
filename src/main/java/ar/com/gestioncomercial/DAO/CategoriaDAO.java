/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.Categoria;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class CategoriaDAO extends AbstractDAO<Categoria> {

    public CategoriaDAO() {
        super(Categoria.class);
    }

    public List<Categoria> getAllCategorias() {
        return getAll();
    }

    @Override
    protected List<Categoria> getAll() {
        Query query = em.createNamedQuery("categoria.getAll");
        return query.getResultList();
    }

}
