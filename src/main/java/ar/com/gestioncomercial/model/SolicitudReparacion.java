package ar.com.gestioncomercial.model;

import javax.persistence.*;

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
    private Cliente cliente;

    @OneToOne(optional = false)
    @JoinColumn(name = "cotizacion_id")
    private Cotizacion cotizacion;

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

}
