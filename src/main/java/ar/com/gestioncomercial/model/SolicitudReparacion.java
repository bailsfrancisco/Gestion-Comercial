package ar.com.gestioncomercial.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//TODO: AMPLIAR
@Entity
@Table(name = "solicitud_reparacion")
public class SolicitudReparacion extends AbstractEntity {

    private String descripcionFallo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

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
}
