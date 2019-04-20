package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.SolicitudReparacion;
import java.util.List;

public interface SolicitudReparacionController extends CrudController<SolicitudReparacion> {
    
    List<SolicitudReparacion> misSolicitudes(AbstractPersona cliente);
    
}
