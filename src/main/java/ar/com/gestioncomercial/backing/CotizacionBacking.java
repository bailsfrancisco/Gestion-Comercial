package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.CotizacionController;
import ar.com.gestioncomercial.model.Cotizacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class CotizacionBacking implements Serializable, CRUDBacking<Cotizacion> {

    private static final Logger logger = Logger.getLogger(CotizacionBacking.class.getName());

    private Cotizacion cotizacion;

    @PostConstruct
    public void init() {
        cotizacion = new Cotizacion();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 15);  // numero de dias a aniadir, o restar en caso de dias<0
        cotizacion.setFechaVencimiento(calendar.getTime());
        //  cotizacion.setFechaVencimiento(new Date());

        cotizacion.setFechaAlta(new Date());
    }

    @EJB
    private CotizacionController cotizacionController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            cotizacionController.create(cotizacion);
            return URLMap.getIndexCotizaciones() + URLMap.getFacesRedirect();

        } catch (EJBException e) {
            JSFUtils.createFacesMessage("Ocurrio un error");
            logger.log(Level.SEVERE, e.getMessage());

        }

        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            cotizacionController.update(cotizacion);
            return URLMap.getIndexCotizaciones() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(Cotizacion entity) {
        try {
            cotizacionController.delete(entity);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage(
                    String.format("Se produjo un error al intentar borrar '%s', Por favor verifique que no hay solicitudes relacionadas a ella.",
                            entity.getDetalles()));
        }
    }

    @Override
    public List<Cotizacion> getAll() {
        return cotizacionController.getAll();
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
