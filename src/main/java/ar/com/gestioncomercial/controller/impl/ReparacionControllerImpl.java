package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ReparacionDAO;
import ar.com.gestioncomercial.controller.ReparacionController;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Reparacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ReparacionControllerImpl implements ReparacionController {

    @EJB
    private ReparacionDAO reparacionDAO;

    @Override
    public void create(Reparacion entity) {
        reparacionDAO.create(entity);
    }

    @Override
    public Reparacion retrieve(Reparacion entity) {
        return reparacionDAO.find(entity.getId());
    }

    @Override
    public Reparacion retrievebyId(Long id) {
        return reparacionDAO.find(id);
    }

    @Override
    public void update(Reparacion entity) {
        reparacionDAO.update(entity);
    }

    @Override
    public void delete(Reparacion entity) {
        reparacionDAO.delete(entity);
    }

    @Override
    public List<Reparacion> getAll() {
        return reparacionDAO.getAllReparaciones();
    }

    @Override
    public Estado[] getEstados() {
        return Estado.values();
    }
}
