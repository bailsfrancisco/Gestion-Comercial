/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ProductoController;
import ar.com.gestioncomercial.exception.NullOrEmptyException;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Producto;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.StringUtils;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.util.Date;
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
public class ProductoBacking implements Serializable, CRUDBacking<Producto> {

    private static final Logger logger = Logger.getLogger(ProductoBacking.class.getName());

    private Producto producto;

    @PostConstruct
    public void init() {
        this.producto = new Producto();
        producto.setFechaAlta(new Date());
    }

    @EJB
    private ProductoController productoController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            if(!(StringUtils.isNullOrEmpty(producto.getNombre()))) {
                productoController.create(producto);
                return URLMap.getIndexProductos() + URLMap.getFacesRedirect();
            }
        } catch (EJBException e) {
            JSFUtils.createFacesMessage("Ocurrio un Error");
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
        JSFUtils.createFacesMessage("El campo Nombre no puede ser nulo o contener espacios");
        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            productoController.update(producto);
            return URLMap.getIndexProductos() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(Producto entity) {
        try {
            productoController.delete(entity);
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage(
                    String.format("Se produjo un error al intentar borrar '%s', Por favor verifique que no hay productos relacionados a el.",
                            entity.getNombre()));
        }
    }

    @Override
    public List<Producto> getAll() {
        try {
            return productoController.getAll();

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

}
