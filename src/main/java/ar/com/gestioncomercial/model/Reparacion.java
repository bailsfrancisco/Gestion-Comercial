package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reparaciones")
public class Reparacion extends AbstractEntity{

    private String diagnostico;

    private Date fechaIngreso;

    private Date fechaEgreso;

    private Float senia;

    private String observaciones;

    private Float precioManoObra;

    private Integer estadoReparacion;

    private AbstractPersona tecnico;

    private AbstractPersona cliente;

    private SolicitudReparacion solicitudReparacion;

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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

    public void setTecnico(AbstractPersona tecnico) {
        this.tecnico = tecnico;
    }

    public AbstractPersona getCliente() {
        return cliente;
    }

    public void setCliente(AbstractPersona cliente) {
        this.cliente = cliente;
    }

    public SolicitudReparacion getSolicitudReparacion() {
        return solicitudReparacion;
    }

    public void setSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        this.solicitudReparacion = solicitudReparacion;
    }
}
