package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ClienteDAO;
import ar.com.gestioncomercial.controller.ClienteController;
import ar.com.gestioncomercial.model.Cliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteControllerImpl extends AbstractPersonaControllerImpl implements ClienteController {

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public void create(Cliente entity) {
        super.create(entity);
    }

    @Override
    public Cliente retrieve(Cliente entity) {
        return (Cliente) super.retrieve(entity);
    }

    public Cliente retrievebyId(Long id) {
        return clienteDAO.find(id);
    }


    @Override
    public void update(Cliente entity) {
        super.update(entity);
    }

    @Override
    public void delete(Cliente entity) {
        super.delete(entity);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteDAO.getAllClientes();
    }
}
