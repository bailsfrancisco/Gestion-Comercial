package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.*;

public interface NotificationController {

    void notificarCambioEstadoReparacion(Reparacion reparacion);

    void notificarStockMinimo(Producto producto);

    void notificarNuevaSolicitudReparacion(SolicitudReparacion solicitudReparacion);

    void notificarNuevaCotizacion(Cotizacion cotizacion);

    void notificarCambioEstadoSolicitud(SolicitudReparacion solicitudReparacion);

    void notificarCambioEstadoCotizacion(Cotizacion cotizacion, String verbo, String mensaje);
}
