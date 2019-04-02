package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.SolicitudReparacionDAO;
import ar.com.gestioncomercial.controller.SolicitudReparacionController;
import ar.com.gestioncomercial.model.SolicitudReparacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SolicitudReparacionControllerImpl implements SolicitudReparacionController {

    @EJB
    private SolicitudReparacionDAO solicitudReparacionDAO;

    @Override
    public void create(SolicitudReparacion entity) {
        solicitudReparacionDAO.create(entity);
    }

    @Override
    public SolicitudReparacion retrieve(SolicitudReparacion entity) {
        return solicitudReparacionDAO.find(entity.getId());
    }

    @Override
    public SolicitudReparacion retrievebyId(Long id) {
        return solicitudReparacionDAO.find(id);
    }

    @Override
    public void update(SolicitudReparacion entity) {
        solicitudReparacionDAO.update(entity);
    }

    @Override
    public void delete(SolicitudReparacion entity) {
        solicitudReparacionDAO.delete(entity);
    }

    @Override
    public List<SolicitudReparacion> getAll() {
        return solicitudReparacionDAO.getSolicitudesReparacion();
    }
}
