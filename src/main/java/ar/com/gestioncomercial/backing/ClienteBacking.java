/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ClienteController;
import ar.com.gestioncomercial.controller.UsuarioController;
import ar.com.gestioncomercial.exception.NullOrEmptyException;
import ar.com.gestioncomercial.model.CategoriaIVA;
import ar.com.gestioncomercial.model.Cliente;
import ar.com.gestioncomercial.model.Usuario;
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
 * @author Bails Francisco
 */
@Named
@ViewScoped
public class ClienteBacking implements Serializable, CRUDBacking<Cliente> {

    private static final Logger logger = Logger.getLogger(ClienteBacking.class.getName());

    private Cliente cliente;

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        this.usuario = new Usuario();
        cliente.setFechaAlta(new Date());
        usuario.setFechaAlta(new Date());
    }

    @EJB
    private ClienteController clienteController;

    @EJB
    private UsuarioController usuarioController;

    @EJB
    private URLMap urlMap;

    private List<Cliente> getClientes() {
        return clienteController.getAll();
    }

    @Override
    public String create() {
        try {
            StringUtils.areNullOrEmpty(usuario.getNombreUsuario(), usuario.getPassword());
            cliente.setUsuario(usuario);
            clienteController.create(cliente);

            return URLMap.getIndexClientes() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            return null;
        } catch (NullOrEmptyException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Campos: Nombre de usuario y Contraseña no pueden ser nulos");
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
            usuarioController.update(cliente.getUsuario());
            clienteController.update(cliente);
            return URLMap.getIndexClientes() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Cliente entity) {
        clienteController.delete(entity);
    }

    @Override
    public List<Cliente> getAll() {
        return getClientes();
    }

    public CategoriaIVA[] getCategoriasIVA() {
        return clienteController.getCategoiasIVA();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
