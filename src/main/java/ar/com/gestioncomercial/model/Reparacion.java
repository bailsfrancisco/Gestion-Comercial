package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
})
public class Reparacion extends AbstractEntity {

    private String diagnostico;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEgreso;

    private Float senia;

    private String observaciones;

    private Float precioManoObra;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToMany
    @JoinTable(name = "reparacion_tecnico",
            joinColumns = @JoinColumn(name = "reparacion_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private List<Empleado> tecnicos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private AbstractPersona cliente;

    @OneToOne(optional = false)
    @JoinColumn(name = "solicitud_reparacion_id")
    private SolicitudReparacion solicitud_reparacion;

    public Reparacion() {

    }

    public Reparacion(String diagnostico, Date fechaEgreso, Float senia, String observaciones, Float precioManoObra, Estado estado, Cliente cliente, List<Empleado> tecnicos, SolicitudReparacion solicitud_reparacion) {
        this.diagnostico = diagnostico;
        this.fechaEgreso = fechaEgreso;
        this.senia = senia;
        this.observaciones = observaciones;
        this.precioManoObra = precioManoObra;
        this.estado = estado;
        this.cliente = cliente;
        this.tecnicos = tecnicos;
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

    public Float getSenia() {
        return senia;
    }

    public void setSenia(Float senia) {
        this.senia = senia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Float getPrecioManoObra() {
        return precioManoObra;
    }

    public void setPrecioManoObra(Float precioManoObra) {
        this.precioManoObra = precioManoObra;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Empleado> getTecnicos() {
        return tecnicos;
    }

    public void setProveedores(List<Empleado> tecnicos) {
        this.tecnicos = tecnicos;
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
}
