/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ClienteController;
import ar.com.gestioncomercial.controller.FacturaController;
import ar.com.gestioncomercial.controller.PersonaController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Cliente;
import ar.com.gestioncomercial.model.Cotizacion;
import ar.com.gestioncomercial.model.Factura;
import ar.com.gestioncomercial.model.SolicitudReparacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.util.ArrayList;
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
    private AbstractPersona cliente;
    private Cotizacion cotizacion;
    private SolicitudReparacion solicitudReparacion;
    private List<Long> clienteId;

    @PostConstruct
    public void init() {
        this.factura = new Factura();
        this.clienteId = new ArrayList<>();
        factura.setFechaAlta(new Date());
    }

    @EJB
    private FacturaController facturaController;

    @EJB
    private PersonaController personaController;

    @EJB
    private ClienteController clienteController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            facturaController.create(factura);
            return URLMap.getIndexReparaciones() + URLMap.getFacesRedirect();
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

    public List<Long> getClienteId() {
        return clienteId;
    }

    public void setClienteId(List<Long> clienteId) {
        this.clienteId = clienteId;
    }

    public AbstractPersona getCliente() {
        return cliente;
    }

    public void setCliente(AbstractPersona cliente) {
        this.cliente = cliente;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public SolicitudReparacion getSolicitudReparacion() {
        return solicitudReparacion;
    }

    public void setSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        this.solicitudReparacion = solicitudReparacion;
    }

    public PersonaController getPersonaController() {
        return personaController;
    }

    public void setPersonaController(PersonaController personaController) {
        this.personaController = personaController;
    }

    //metodo para agregar los datos de los clientes por medio del dialogClientes
    public void agregarDatosCliente() {
        if (this.factura.getCliente() == null) {
            this.factura.setCliente(new Cliente());
        }
        clienteId.forEach(
                id -> {
                    AbstractPersona cliente_factura = personaController.retrievebyId(id);
                    if (this.factura.getCliente() != cliente_factura) {
                        this.factura.setCliente(cliente_factura);
                    }
                }
        );
        clienteId = new ArrayList<>();
    }

}
