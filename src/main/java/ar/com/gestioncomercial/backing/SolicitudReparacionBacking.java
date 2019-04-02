package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.SolicitudReparacionController;
import ar.com.gestioncomercial.model.SolicitudReparacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class SolicitudReparacionBacking implements Serializable, CRUDBacking<SolicitudReparacion> {

    private static final Logger logger = Logger.getLogger(SolicitudReparacionBacking.class.getName());

    private SolicitudReparacion solicitudReparacion;

    @EJB
    private SolicitudReparacionController solicitudReparacionController;

    @PostConstruct
    public void init(){
        solicitudReparacion = new SolicitudReparacion();
    }

    @Override
    public String create() {
        try {
            solicitudReparacionController.create(solicitudReparacion);
            return URLMap.getIndexSolicitudes() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try{
            solicitudReparacionController.update(solicitudReparacion);
            return URLMap.getIndexSolicitudes() + URLMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(SolicitudReparacion entity) {
        try{
            solicitudReparacionController.delete(entity);
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }

    }

    @Override
    public List<SolicitudReparacion> getAll() {
        return solicitudReparacionController.getAll();
    }

    public SolicitudReparacion getSolicitudReparacion() {
        return solicitudReparacion;
    }

    public void setSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        this.solicitudReparacion = solicitudReparacion;
    }
}
