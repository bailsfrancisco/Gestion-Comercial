/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.DAO.AbstractPersonaDAO;
import ar.com.gestioncomercial.DAO.ClienteDAO;
import ar.com.gestioncomercial.model.Cliente;
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
public class ClienteBacking implements Serializable, CRUDBacking<Cliente> {

    private Cliente cliente;

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
    }

    @EJB
    private AbstractPersonaDAO abstractPersonaDAO;

    @EJB
    private ClienteDAO clienteDAO;

    @EJB
    private URLMap urlMap;

    private List<Cliente> getClientes() {
        return clienteDAO.getAllClientes();
    }

    @Override
    public String create() {
        try {
            abstractPersonaDAO.create(cliente);
            return URLMap.getIndexClientes() + URLMap.getFacesRedirect();
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
            abstractPersonaDAO.update(cliente);
            return URLMap.getIndexClientes() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Cliente entity) {
        abstractPersonaDAO.delete(entity);
    }

    @Override
    public List<Cliente> getAll() {
        return getClientes();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AbstractPersonaDAO getAbstractPersonaDAO() {
        return abstractPersonaDAO;
    }

    public void setAbstractPersonaDAO(AbstractPersonaDAO abstractPersonaDAO) {
        this.abstractPersonaDAO = abstractPersonaDAO;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
