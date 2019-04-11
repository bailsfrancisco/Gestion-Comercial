package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.controller.ClienteController;
import ar.com.gestioncomercial.controller.ImageController;
import ar.com.gestioncomercial.controller.SolicitudReparacionController;
import ar.com.gestioncomercial.model.Estado;
import ar.com.gestioncomercial.model.Image;
import ar.com.gestioncomercial.model.SolicitudReparacion;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ar.com.gestioncomercial.servlet.ImageServlet.IMAGES_PATH;

@Named
@ViewScoped
public class SolicitudReparacionBacking implements Serializable, CRUDBacking<SolicitudReparacion> {

    private static final Logger logger = Logger.getLogger(SolicitudReparacionBacking.class.getName());

    private SolicitudReparacion solicitudReparacion;

    private UploadedFile file;

    @Inject
    private SessionBacking sessionBacking;

    @EJB
    private SolicitudReparacionController solicitudReparacionController;

    @EJB
    private ImageController imageController;

    @EJB
    private ClienteController clienteController;

    @PostConstruct
    public void init() {
        solicitudReparacion = new SolicitudReparacion();
        if (solicitudReparacion.getFileNames() == null) {
            solicitudReparacion.setFileNames(new ArrayList<>());
        }
    }

    @Override
    public String create() {
        try {

            solicitudReparacion.setCliente(clienteController.getByUsuario(sessionBacking.getUsuario()));
            solicitudReparacion.setFechaAlta(new Date());
            solicitudReparacion.setEstado(Estado.PENDIENTE);
            solicitudReparacionController.create(solicitudReparacion);
            return URLMap.getIndexSolicitudes() + URLMap.getFacesRedirect();

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
            solicitudReparacionController.update(solicitudReparacion);
            return URLMap.getIndexSolicitudes() + URLMap.getFacesRedirect();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
            return null;
        }
    }

    @Override
    public void delete(SolicitudReparacion entity) {
        try {
            solicitudReparacionController.delete(entity);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage("Ocurrio un Error");
        }

    }

    @Override
    public List<SolicitudReparacion> getAll() {
        return solicitudReparacionController.getAll();
    }

    public void saveImage(FileUploadEvent event) {
        try (InputStream input = event.getFile().getInputstream()) {
            String fileName = sessionBacking.getUsuario().getNombreUsuario()
                    + "_"
                    + new Date().toString()
                    + "_"
                    + event.getFile().getFileName();
            Files.copy(input, new File(IMAGES_PATH, fileName).toPath());
            Image image = new Image(fileName);
            image.setSolicitud(solicitudReparacion);
            imageController.create(image);
            solicitudReparacion.addFileName(image);
        } catch (Exception e) {
            JSFUtils.createFacesMessage("Ocurrio un Error al subir su Imagen");
        }
    }

    public SolicitudReparacion getSolicitudReparacion() {
        return solicitudReparacion;
    }

    public void setSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        this.solicitudReparacion = solicitudReparacion;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
