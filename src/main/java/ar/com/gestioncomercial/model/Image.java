package ar.com.gestioncomercial.model;

import javax.persistence.*;

@Entity
@Table(name = "images")
@NamedQueries({
        @NamedQuery(
                name = "images.getAllImages",
                query = "select i from Image i")
})
public class Image extends  AbstractEntity {

    private String fileName;

    @ManyToOne
    @JoinColumn(name = "solicitud_reparacion_id")
    private SolicitudReparacion solicitud;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public SolicitudReparacion getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudReparacion solicitud) {
        this.solicitud = solicitud;
    }

    public Image(String fileName) {
        this.fileName = fileName;
    }

    public Image() {
    }
}
