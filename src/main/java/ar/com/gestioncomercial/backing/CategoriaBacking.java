/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.DAO.CategoriaDAO;
import ar.com.gestioncomercial.model.Categoria;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bailsfrancisco
 */
@Named
@ViewScoped
public class CategoriaBacking implements Serializable, CRUDBacking<Categoria> {

    private static final Logger logger = Logger.getLogger(CategoriaBacking.class.getName());

    private Categoria categoria;
    
    private String nombre;

    @PostConstruct
    public void init() {
        this.categoria = new Categoria();
        this.nombre = null;
    }

    @EJB
    private CategoriaDAO categoriaDAO;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            categoria.setNombre(this.nombre);
            categoriaDAO.create(categoria);
            return URLMap.getIndexCategorias() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            categoriaDAO.update(categoria);
            return URLMap.getIndexCategorias() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Categoria entity) {
        try {
            categoriaDAO.delete(entity);
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage(
                    String.format("Se produjo un error al intentar borrar '%s', Por favor verifique que no hay productos relacionados a ella.",
                            entity.getNombre()));
        }
    }

    @Override
    public List<Categoria> getAll() {
        try {
            return categoriaDAO.getAllCategorias();

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
    
    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
