package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ClienteDAO;
import ar.com.gestioncomercial.controller.ClienteController;
import ar.com.gestioncomercial.model.CategoriaIVA;
import ar.com.gestioncomercial.model.AbstractPersona;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import javax.mail.Session;

@Stateless
public class ClienteControllerImpl extends AbstractPersonaControllerImpl implements ClienteController {

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public AbstractPersona retrievebyId(Long id) {
        return clienteDAO.find(id);
    }

    @Override
    public List<AbstractPersona> getAll() {
        return clienteDAO.getAllClientes();
    }

    @Override
    public CategoriaIVA[] getCategoriasIVA() {
        return CategoriaIVA.values();
    }
}
