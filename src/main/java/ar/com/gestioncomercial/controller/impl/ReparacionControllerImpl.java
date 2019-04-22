package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.ReparacionDAO;
import ar.com.gestioncomercial.controller.NotificationController;
import ar.com.gestioncomercial.controller.ReparacionController;
import ar.com.gestioncomercial.controller.SolicitudReparacionController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Reparacion;
import ar.com.gestioncomercial.model.SolicitudReparacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ReparacionControllerImpl implements ReparacionController {

    @EJB
    private ReparacionDAO reparacionDAO;

    @EJB
    private NotificationController notificationController;

    @EJB
    private SolicitudReparacionController solicitudReparacionController;

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

    @Override
    public List<Reparacion> findByEstado(Estado estado) {
        return reparacionDAO.findByEstado(estado);
    }

    @Override
    public List<Reparacion> findByCliente(AbstractPersona cliente) {
        return reparacionDAO.findByCliente(cliente);
    }

    @Override
    public void create(Reparacion reparacion, String mensaje) {
        create(reparacion);
        handleEstadoSolicitudReparacion(reparacion, mensaje);
    }

    @Override
    public void update(Reparacion reparacion, String mensaje) {
        handleEstadoSolicitudReparacion(reparacion, mensaje);
        update(reparacion);
    }

    private void handleEstadoSolicitudReparacion(Reparacion entity, String mensaje){
        SolicitudReparacion solicitudReparacion = null;
        if (entity.getId() != null){
            solicitudReparacion = retrieve(entity).getSolicitud_reparacion();
        }else {
            solicitudReparacion = entity.getSolicitud_reparacion();
        }
        if (solicitudReparacion.getEstado() != entity.getEstado()){
            solicitudReparacion.setEstado(entity.getEstado());
            solicitudReparacionController.update(solicitudReparacion);
            notificationController.notificarCambioEstadoReparacion(entity, mensaje);
        }
    }
}
