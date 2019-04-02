/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import ar.com.gestioncomercial.model.*;
import ar.com.gestioncomercial.utils.URLMap;
import java.util.logging.Level;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Bails Francisco
 */
@Named
@ViewScoped
public class PersonaBacking extends AbstractPersonaBacking {

    private static final Logger logger = Logger.getLogger(PersonaBacking.class.getName());

    private Empleado empleado;
    private Cliente cliente;
    private Proveedor proveedor;

    @PostConstruct
    @Override
    public void init() {
        this.empleado = new Empleado();
        this.cliente = new Cliente();
        this.proveedor = new Proveedor();
        super.init();
    }

    @Override
    public String create() {
        try {
            super.getPersonaController().insertarPersona(empleado);
            super.getPersonaController().insertarPersona(cliente);
            super.getPersonaController().insertarPersona(proveedor);
            return URLMap.getIndexPersonas() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public String update() {
        try {
            super.getPersonaController().actualizarPersona(empleado);
            super.getPersonaController().actualizarPersona(cliente);
            super.getPersonaController().actualizarPersona(proveedor);
            return URLMap.getIndexPersonas() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
