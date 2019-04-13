package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reparacion")
@NamedQueries({
    @NamedQuery(
            name = "reparacion.getAllReparaciones",
            query = "select r from Reparacion r")
    ,
    @NamedQuery(
            name = "reparacion.findByEstado",
            query = "SELECT r FROM Reparacion as r WHERE r.estado = :estado"
    )
    ,
    @NamedQuery(
            name = "reparacion.findByCliente",
            query = "SELECT r FROM Reparacion as r WHERE r.cliente = :cliente"
    )
})
public class Reparacion extends AbstractEntity {

    private String diagnostico;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEgreso;

    private String observaciones;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tecnico")
    private AbstractPersona tecnico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private AbstractPersona cliente;

    @OneToOne(optional = false)
    @JoinColumn(name = "solicitud_reparacion_id")
    private SolicitudReparacion solicitud_reparacion;

    @OneToOne(optional = false)
    @JoinColumn(name = "cotizacion")
    private Cotizacion cotizacion;

    public Reparacion() {

    }

    public Reparacion(String diagnostico, Date fechaEgreso, Float senia, String observaciones, Float precioManoObra, Estado estado, Cliente cliente, Empleado tecnico, SolicitudReparacion solicitud_reparacion) {
        this.diagnostico = diagnostico;
        this.fechaEgreso = fechaEgreso;
        this.observaciones = observaciones;
        this.estado = estado;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.solicitud_reparacion = solicitud_reparacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public AbstractPersona getTecnico() {
        return tecnico;
    }

    public void setTecnico(Empleado tecnico) {
        this.tecnico = tecnico;
    }

    public SolicitudReparacion getSolicitud_reparacion() {
        return solicitud_reparacion;
    }

    public void setSolicitud_reparacion(SolicitudReparacion solicitud_reparacion) {
        this.solicitud_reparacion = solicitud_reparacion;
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
