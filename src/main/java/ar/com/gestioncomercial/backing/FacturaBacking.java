/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.FacturaController;
import ar.com.gestioncomercial.model.Factura;
import ar.com.gestioncomercial.utils.JSFUtils;
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
public class FacturaBacking implements Serializable, CRUDBacking<Factura> {

    private static final Logger logger = Logger.getLogger(FacturaBacking.class.getName());

    private Factura factura;

    @PostConstruct
    public void init() {
        this.factura = new Factura();
        factura.setFechaAlta(new Date());
    }

    @EJB
    private FacturaController facturaController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            facturaController.create(factura);
        } catch (EJBException e) {
            JSFUtils.createFacesMessage("Ocurrio un Error");
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
            facturaController.update(factura);
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
        return null;
    }

    @Override
    public void delete(Factura entity) {
        try {
            facturaController.delete(entity);
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
    }

    @Override
    public List<Factura> getAll() {
        try {
            return facturaController.getAll();

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FacturaController getFacturaController() {
        return facturaController;
    }

    public void setFacturaController(FacturaController facturaController) {
        this.facturaController = facturaController;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

}
