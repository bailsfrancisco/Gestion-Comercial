package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ProveedorDAO;
import ar.com.gestioncomercial.controller.ProveedorController;
import ar.com.gestioncomercial.model.Proveedor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProveedorControllerImpl extends AbstractPersonaControllerImpl implements ProveedorController {

    @EJB
    private ProveedorDAO proveedorDAO;

    @Override
    public void create(Proveedor entity) {
        super.create(entity);
    }

    @Override
    public Proveedor retrieve(Proveedor entity) {
        return (Proveedor) super.retrieve(entity);
    }

    @Override
    public Proveedor retrievebyId(Long id) {
        return proveedorDAO.find(id);
    }


    @Override
    public void update(Proveedor entity) {
        super.update(entity);
    }

    @Override
    public void delete(Proveedor entity) {
        super.delete(entity);
    }

    @Override
    public List<Proveedor> getAll() {
        return proveedorDAO.getAllProveedores();
    }
}
