package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.CotizacionController;
import ar.com.gestioncomercial.controller.ProductoController;
import ar.com.gestioncomercial.controller.SolicitudReparacionController;
import ar.com.gestioncomercial.model.Cotizacion;
import ar.com.gestioncomercial.model.Producto;
import ar.com.gestioncomercial.model.SolicitudReparacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
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

    private SolicitudReparacion solicitudReparacion;

    private double precioTotal;

    private List<Long> productosIds;

    @PostConstruct
    public void init() {
        cotizacion = new Cotizacion();
        solicitudReparacion = new SolicitudReparacion();
        precioTotal = cotizacion.getPrecioTotal();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 15);  // numero de dias a aniadir, o restar en caso de dias<0
        cotizacion.setFechaVencimiento(calendar.getTime());
        //  cotizacion.setFechaVencimiento(new Date());

        cotizacion.setFechaAlta(today);
    }

    @EJB
    private CotizacionController cotizacionController;

    @EJB
    private ProductoController productoController;

    @EJB
    private SolicitudReparacionController solicitudReparacionController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            solicitudReparacionController.create(solicitudReparacion);
            cotizacion.setSolicitudReparacion(solicitudReparacion);
            cotizacion.setPrecioTotal(this.precioTotal);
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

    public void agregarProductos() {

        if (this.cotizacion.getInsumos() == null) {
            this.cotizacion.setInsumos(new ArrayList<>());
        }
        productosIds.forEach(
                id -> {
                    Producto producto = productoController.retrievebyId(id);
                    if (!this.cotizacion.getInsumos().contains(producto)) {
                        this.cotizacion.addInsumo(producto);
                    }
                }
        );
        productosIds = new ArrayList<>();
    }

    public void quitarProducto(Producto producto) {
        this.cotizacion.removeInsumo(producto);
        handlePrecioTotal();
    }

    public void handlePrecioTotal(){
        double precioTotalInsumos = cotizacion.getInsumos()!= null ?
                cotizacionController.getPrecioTotalInsumos(cotizacion) : 0;

        precioTotal = ( precioTotalInsumos + cotizacion.getPrecioManoObra())- cotizacion.getSenia();
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

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }

    public SolicitudReparacion getSolicitudReparacion() {
        return solicitudReparacion;
    }

    public void setSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        this.solicitudReparacion = solicitudReparacion;
    }
}
