package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.CotizacionDAO;
import ar.com.gestioncomercial.controller.CotizacionController;
import ar.com.gestioncomercial.controller.NotificationController;
import ar.com.gestioncomercial.controller.SolicitudReparacionController;
import ar.com.gestioncomercial.model.Cotizacion;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Producto;
import ar.com.gestioncomercial.model.SolicitudReparacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CotizacionControllerImpl implements CotizacionController {

    @EJB
    private CotizacionDAO cotizacionDAO;

    @EJB
    private NotificationController notificationController;

    @EJB
    private SolicitudReparacionController solicitudReparacionController;

    @Override
    public void create(Cotizacion entity) {
        cotizacionDAO.create(entity);
    }

    @Override
    public Cotizacion retrieve(Cotizacion entity) {
        return null;
    }

    @Override
    public Cotizacion retrievebyId(Long id) {
        return null;
    }

    @Override
    public void update(Cotizacion entity) {
        cotizacionDAO.update(entity);
    }

    @Override
    public void delete(Cotizacion entity) {
        cotizacionDAO.delete(entity);
    }

    @Override
    public List<Cotizacion> getAll() {
        return cotizacionDAO.getAllCotizaciones();
    }

    public CotizacionDAO getCotizacionDAO() {
        return cotizacionDAO;
    }

    public void setCategoriaDAO(CotizacionDAO cotizacionDAO) {
        this.cotizacionDAO = cotizacionDAO;
    }

    @Override
    public double getPrecioTotalInsumos(Cotizacion cotizacion) {
        return cotizacion.getInsumos().stream().mapToDouble(Producto::getPrecioUnitario).sum();
    }

    @Override
    public void handleCotizacionRespuesta(boolean acepto, String respuesta, Cotizacion cotizacion) {
        String verbo = null;
        SolicitudReparacion solicitudReparacion = cotizacion.getSolicitudReparacion();
        if (acepto) {
            verbo = "aceptó";
            solicitudReparacion.setEstado(Estado.ACEPTADA);
        } else {
            verbo = "rechazó";
            solicitudReparacion.setEstado(Estado.ANULADA);
        }
        solicitudReparacionController.update(solicitudReparacion);
        update(cotizacion);
        notificationController.notificarCambioEstadoCotizacion(cotizacion, verbo, respuesta);

    }
}
