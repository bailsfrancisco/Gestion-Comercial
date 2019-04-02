/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.DAO.AbstractPersonaDAO;
import ar.com.gestioncomercial.DAO.EmpleadoDAO;
import ar.com.gestioncomercial.model.Empleado;
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
public class EmpleadoBacking implements Serializable, CRUDBacking<Empleado> {

    private Empleado empleado;

    @PostConstruct
    public void init() {
        this.empleado = new Empleado();
    }

    @EJB
    private AbstractPersonaDAO abstractPersonaDAO;

    @EJB
    private EmpleadoDAO empleadoDAO;

    @EJB
    private URLMap urlMap;

    private List<Empleado> getEmpleados() {
        return empleadoDAO.getAllEmpleados();
    }

    @Override
    public String create() {
        try {
            abstractPersonaDAO.create(empleado);
            return URLMap.getIndexEmpleados() + URLMap.getFacesRedirect();
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
            abstractPersonaDAO.update(empleado);
            return URLMap.getIndexEmpleados() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Empleado entity) {
        abstractPersonaDAO.delete(entity);
    }

    @Override
    public List<Empleado> getAll() {
        return getEmpleados();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public AbstractPersonaDAO getAbstractPersonaDAO() {
        return abstractPersonaDAO;
    }

    public void setAbstractPersonaDAO(AbstractPersonaDAO abstractPersonaDAO) {
        this.abstractPersonaDAO = abstractPersonaDAO;
    }

    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
