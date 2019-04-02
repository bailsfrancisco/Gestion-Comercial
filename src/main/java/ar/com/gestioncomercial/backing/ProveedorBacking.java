/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.DAO.AbstractPersonaDAO;
import ar.com.gestioncomercial.DAO.ProveedorDAO;
import ar.com.gestioncomercial.controller.ProveedorController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Proveedor;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.util.List;
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

    private Proveedor proveedor;

    @PostConstruct
    public void init() {
        this.proveedor = new Proveedor();
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
            return null;
        }
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
            return null;
        }
    }

    @Override
    public void delete(Proveedor entity) {
        proveedorController.delete(entity);
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
}
