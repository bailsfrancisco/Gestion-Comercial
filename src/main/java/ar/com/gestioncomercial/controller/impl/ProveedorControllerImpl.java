package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ProveedorDAO;
import ar.com.gestioncomercial.controller.ProveedorController;
import ar.com.gestioncomercial.model.CategoriaIVA;
import ar.com.gestioncomercial.model.AbstractPersona;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProveedorControllerImpl extends AbstractPersonaControllerImpl implements ProveedorController {

    @EJB
    private ProveedorDAO proveedorDAO;

    @Override
    public AbstractPersona retrievebyId(Long id) {
        return proveedorDAO.find(id);
    }

    @Override
    public List<AbstractPersona> getAll() {
        return proveedorDAO.getAllProveedores();
    }

    @Override
    public CategoriaIVA[] getCategoriasIVA() {
        return CategoriaIVA.values();
    }
}
