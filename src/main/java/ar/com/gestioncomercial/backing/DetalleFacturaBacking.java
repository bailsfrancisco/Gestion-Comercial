/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.DetalleFacturaController;
import ar.com.gestioncomercial.model.DetalleFactura;
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
public class DetalleFacturaBacking implements Serializable, CRUDBacking<DetalleFactura> {

    private static final Logger logger = Logger.getLogger(DetalleFacturaBacking.class.getName());

    private DetalleFactura detalle_factura;

    @PostConstruct
    public void init() {
        this.detalle_factura = new DetalleFactura();
        detalle_factura.setFechaAlta(new Date());
    }

    @EJB
    private DetalleFacturaController detallefacturaController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            detallefacturaController.create(detalle_factura);
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
            detallefacturaController.update(detalle_factura);
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
        return null;
    }

    @Override
    public void delete(DetalleFactura entity) {
        try {
            detallefacturaController.delete(entity);
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
    }

    @Override
    public List<DetalleFactura> getAll() {
        try {
            return detallefacturaController.getAll();

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    public DetalleFactura getDetalle_factura() {
        return detalle_factura;
    }

    public void setDetalle_factura(DetalleFactura detalle_factura) {
        this.detalle_factura = detalle_factura;
    }

    public DetalleFacturaController getDetallefacturaController() {
        return detallefacturaController;
    }

    public void setDetallefacturaController(DetalleFacturaController detallefacturaController) {
        this.detallefacturaController = detallefacturaController;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

}
