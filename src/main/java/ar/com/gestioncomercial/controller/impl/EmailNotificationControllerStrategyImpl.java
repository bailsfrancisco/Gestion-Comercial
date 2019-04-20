package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.controller.EmpleadoController;
import ar.com.gestioncomercial.controller.NotificationController;
import ar.com.gestioncomercial.model.*;
import ar.com.gestioncomercial.utils.EmailUtils;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EmailNotificationControllerStrategyImpl implements NotificationController {


    @EJB
    private EmpleadoController empleadoController;

/*    @EJB
    private ClienteController clienteController;*/

    @Override
    public void notificarCambioEstadoReparacion(Reparacion reparacion) {
        AbstractPersona cliente = reparacion.getCliente();
        EmailUtils.reparacionCambioEstadoEmail(cliente.getNombre(),
                cliente.getMail(),
                reparacion.getEstado().getEstadoString()
        );

    }

    @Override
    public void notificarStockMinimo(Producto producto) {
        List<String> adminsEmails = getAdminsEmails();

        EmailUtils.productoStockMinimoEmail(producto.getNombre(),
                    producto.getStockMinimo(),
                    adminsEmails
        );
    }

    @Override
    public void notificarNuevaSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        AbstractPersona cliente = solicitudReparacion.getCliente();
        EmailUtils.nuevaSolicitudReparacionEmail(cliente.getNombre(),
                solicitudReparacion.getId(),
                getAdminsEmails()
        );
    }

    @Override
    public void notificarCambioEstadoSolicitud(SolicitudReparacion solicitudReparacion) {
        AbstractPersona cliente = solicitudReparacion.getCliente();

        EmailUtils.reparacionCambioEstadoEmail(cliente.getNombre(),
                    cliente.getMail(),
                    solicitudReparacion.getEstado().getEstadoString()
        );
    }

    @Override
    public void notificarCambioEstadoCotizacion(Cotizacion cotizacion) {
        AbstractPersona cliente = cotizacion.getSolicitudReparacion().getCliente();

        EmailUtils.reparacionCambioEstadoEmail(cliente.getNombre(),
                cliente.getMail(),
                cotizacion.getSolicitudReparacion().getEstado().getEstadoString()
        );

    }

    private List<String> getEmailPersonas(List<AbstractPersona> notificados){
        return notificados.stream()
                .map(AbstractPersona::getMail).collect(Collectors.toList());
    }

    private List<String> getAdminsEmails(){
        return getEmailPersonas(empleadoController.getAllAdmins());
    }
}
