package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ReparacionController;
import ar.com.gestioncomercial.model.Reparacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class ReparacionBacking implements CRUDBacking<Reparacion> {

    private static final Logger logger = Logger.getLogger(ReparacionBacking.class.getName());

    private Reparacion reparacion;

    @PostConstruct
    public void init(){
        reparacion = new Reparacion();
    }

    @EJB
    private ReparacionController reparacionController;

    @Override
    public String create() {
        try{
            reparacionController.create(reparacion);
            return URLMap.getIndexReparaciones() + URLMap.getFacesRedirect();

        }catch(EJBException e){
            logger.log(Level.SEVERE, e.getMessage());

        }
        JSFUtils.createFacesMessage("Ocurrio un Error");
        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try{
            reparacionController.update(reparacion);
            return URLMap.getIndexUsuarios() + URLMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(Reparacion entity) {
        try{
            reparacionController.delete(reparacion);
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
    }

    @Override
    public List<Reparacion> getAll() {
        return reparacionController.getAll();
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }
}
