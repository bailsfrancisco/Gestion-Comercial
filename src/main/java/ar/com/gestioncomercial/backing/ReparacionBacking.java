package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ReparacionController;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Reparacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class ReparacionBacking implements Serializable, CRUDBacking<Reparacion> {

    private static final Logger logger = Logger.getLogger(ReparacionBacking.class.getName());

    private Reparacion reparacion;

    private Estado estadoNuevo;

    private String mensajeCambioEstado;

    @PostConstruct
    public void init() {
        reparacion = new Reparacion();
        reparacion.setFechaAlta(new Date());
    }

    @EJB
    private ReparacionController reparacionController;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            reparacion.setFechaAlta(new Date());
            reparacionController.create(reparacion,"");
            return URLMap.getIndexReparaciones() + URLMap.getFacesRedirect();
        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
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
            reparacionController.update(reparacion);
            return URLMap.getIndexReparaciones() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(Reparacion entity) {
        try {
            reparacionController.delete(entity);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }
    }

    public Estado[] getEstados() {
        return reparacionController.getEstados();
    }

    @Override
    public List<Reparacion> getAll() {
        return reparacionController.getAll();
    }

    public void updateEstado(){
        try {
            reparacion.setEstado(estadoNuevo);
            reparacionController.update(reparacion, mensajeCambioEstado);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error, El estado no puede ser nulo");
        }
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public Estado getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(Estado estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    /*public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
		//Map<String,Object> parametros= new HashMap<String,Object>();
		//parametros.put("txtUsuario", "MitoCode");
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporte-orden-reparacion.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(this.getPersonas()));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}*/

    public String getMensajeCambioEstado() {
        return mensajeCambioEstado;
    }

    public void setMensajeCambioEstado(String mensajeCambioEstado) {
        this.mensajeCambioEstado = mensajeCambioEstado;
    }
}
