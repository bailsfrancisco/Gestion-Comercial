/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ProductoController;
import ar.com.gestioncomercial.controller.ProveedorController;
import ar.com.gestioncomercial.model.Producto;
import ar.com.gestioncomercial.model.Proveedor;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Bails Francisco
 */
@Named
@ViewScoped
public class ProveedorBacking implements Serializable, CRUDBacking<Proveedor> {

    private static final Logger logger = Logger.getLogger(ProveedorBacking.class.getName());

    private Proveedor proveedor;

    private List<Long> productosIds;

    @EJB
    private ProductoController productoController;

    @PostConstruct
    public void init() {
        this.proveedor = new Proveedor();
        this.productosIds = new ArrayList<>();
    }

    @EJB
    private ProveedorController proveedorController;

    @EJB
    private URLMap urlMap;

    private List<Proveedor> getProveedores() {
        return proveedorController.getAll();
    }

    @Override
    public String create() {
        try {
            proveedorController.create(proveedor);
            return URLMap.getIndexProveedores() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    public void agregarProductos(){

        if(proveedor.getProductos()==null){
            proveedor.setProductos(new ArrayList<>());
        }
        productosIds.forEach(
                id -> {
                    Producto producto = productoController.retrievebyId(id);
                    if (!proveedor.getProductos().contains(producto)){
                        proveedor.addProducto(producto);
                    }
                }
        );
        productosIds = new ArrayList<>();
    }

    public void quitarProducto(Producto producto){
        this.proveedor.getProductos().remove(producto);
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            proveedorController.update(proveedor);
            return URLMap.getIndexProveedores() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(Proveedor entity) {
        try{
            proveedorController.delete(entity);
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
    }

    @Override
    public List<Proveedor> getAll() {
        return getProveedores();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }
}
