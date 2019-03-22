package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
@Table(name = "reparacion")
public class Reparacion extends AbstractEntity {

    private String diagnostico;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEgreso;

    private Float senia;

    private String observaciones;

    private Float precioManoObra;

    private Integer estadoReparacion;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "tecnico_id")
    private AbstractPersona tecnico;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "cotizacion_id")
    private Cotizacion cotizacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "solicitud_reparacion_id")
    private SolicitudReparacion solicitud_reparacion;

    public Reparacion() {

    }

    public Reparacion(String diagnostico, Date fechaEgreso, Float senia, String observaciones, Float precioManoObra, Integer estadoReparacion, AbstractPersona tecnico, Cotizacion cotizacion, Cliente cliente, SolicitudReparacion solicitud_reparacion) {
        this.diagnostico = diagnostico;
        this.fechaEgreso = fechaEgreso;
        this.senia = senia;
        this.observaciones = observaciones;
        this.precioManoObra = precioManoObra;
        this.estadoReparacion = estadoReparacion;
        this.tecnico = tecnico;
        this.cotizacion = cotizacion;
        this.cliente = cliente;
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

    public Integer getEstadoReparacion() {
        return estadoReparacion;
    }

    public void setEstadoReparacion(Integer estadoReparacion) {
        this.estadoReparacion = estadoReparacion;
    }

    public AbstractPersona getTecnico() {
        return tecnico;
    }

    public void setTecnico(Cliente tecnico) {
        this.tecnico = tecnico;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public AbstractPersona getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public SolicitudReparacion getSolicitud_reparacion() {
        return solicitud_reparacion;
    }

    public void setSolicitud_reparacion(SolicitudReparacion solicitud_reparacion) {
        this.solicitud_reparacion = solicitud_reparacion;
    }
}
