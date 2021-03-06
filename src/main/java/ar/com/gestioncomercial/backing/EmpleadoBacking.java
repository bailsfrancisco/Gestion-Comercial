/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.EmpleadoController;
import ar.com.gestioncomercial.controller.UsuarioController;
import ar.com.gestioncomercial.exception.NullOrEmptyException;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Empleado;
import ar.com.gestioncomercial.model.Usuario;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.StringUtils;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Bails Francisco
 */
@Named
@ViewScoped
public class EmpleadoBacking implements Serializable, CRUDBacking<AbstractPersona> {

    private static final Logger logger = Logger.getLogger(EmpleadoBacking.class.getName());

    private Empleado empleado;
    private Usuario usuario;
    private Date fechaDesde;
    private Date fechaHasta;
    private double comision;

    @PostConstruct
    public void init() {
        this.empleado = new Empleado();
        this.usuario = new Usuario();
        empleado.setFechaAlta(new Date());
        usuario.setFechaAlta(new Date());
    }

    @EJB
    private EmpleadoController empleadoController;

    @EJB
    private UsuarioController usuarioController;

    @EJB
    private URLMap urlMap;

    private List<AbstractPersona> getEmpleados() {
        return empleadoController.getAll();
    }

    @Override
    public String create() {
        try {
            if(!(StringUtils.isNullOrEmpty(usuario.getNombreUsuario()) ||
                    StringUtils.isNullOrEmpty(usuario.getPassword()))){

                empleado.setUsuario(usuario);
                usuario.setDuenio(empleado);
                empleadoController.create(empleado);

                return URLMap.getIndexEmpleados() + URLMap.getFacesRedirect();
            }

        } catch (EJBException e) {
            JSFUtils.createFacesMessage("Ocurrio un Error");
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
        JSFUtils.createFacesMessage("Campos: Nombre de usuario y Contraseña no pueden ser nulos");
        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            usuarioController.update(empleado.getUsuario());
            empleadoController.update(empleado);
            return URLMap.getIndexEmpleados() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(AbstractPersona entity) {
        empleadoController.delete(entity);
    }

    @Override
    public List<AbstractPersona> getAll() {
        return getEmpleados();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    
    
    public void sueldo() {
        comision = empleadoController.getSueldoTotal(empleado.getPorcentajeComision(), fechaDesde, fechaHasta, empleado.getId());
    }
}
