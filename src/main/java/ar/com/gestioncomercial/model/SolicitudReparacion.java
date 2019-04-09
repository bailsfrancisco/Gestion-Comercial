package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.List;

//TODO: AMPLIAR
@Entity
@Table(name = "solicitud_reparacion")
@NamedQueries({
    @NamedQuery(
            name = "solicitudReparacion.getAllSolicitudes",
            query = "select s from SolicitudReparacion s")
})
public class SolicitudReparacion extends AbstractEntity {

    private String descripcionFallo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private AbstractPersona cliente;

    @OneToOne(optional = false)
    @JoinColumn(name = "cotizacion_id")
    private Cotizacion cotizacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<Image> fileNames;

    public SolicitudReparacion() {

    }

    public SolicitudReparacion(String descripcionFallo, Cliente cliente) {
        this.descripcionFallo = descripcionFallo;
        this.cliente = cliente;
    }

    public String getDescripcionFallo() {
        return descripcionFallo;
    }

    public void setDescripcionFallo(String descripcionFallo) {
        this.descripcionFallo = descripcionFallo;
    }

    public AbstractPersona getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public void setCliente(AbstractPersona cliente) {
        this.cliente = cliente;
    }

    public List<Image> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<Image> fileNames) {
        this.fileNames = fileNames;
    }

    public void addFileName(Image fileName){
        this.fileNames.add(fileName);
    }

    public void removeFileName(Image fileName){
        this.fileNames.remove(fileName);
    }
}
