/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.EmpleadoController;
import ar.com.gestioncomercial.controller.UsuarioController;
import ar.com.gestioncomercial.model.Empleado;
import ar.com.gestioncomercial.model.Usuario;
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
    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.empleado = new Empleado();
        this.usuario = new Usuario();
    }

    @EJB
    private EmpleadoController empleadoController;

    @EJB
    private UsuarioController usuarioController;

    @EJB
    private URLMap urlMap;

    private List<Empleado> getEmpleados() {
        return empleadoController.getAll();
    }

    @Override
    public String create() {
        try {
            //usuarioController.create(usuario);
            empleado.setUsuario(usuario);
            empleadoController.create(empleado);

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
            usuarioController.update(empleado.getUsuario());
            empleadoController.update(empleado);
            return URLMap.getIndexEmpleados() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Empleado entity) {
        empleadoController.delete(entity);
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

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
