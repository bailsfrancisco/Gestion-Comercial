package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "cotizacion")
public class Cotizacion extends AbstractEntity {

    /*
    @ManyToOne
    @JoinColumn(name = "reparacion_id")
    private Reparacion reparacion;
     */
    private String descripcion_cotizacion;
    private Float precioTotal;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    public Cotizacion() {

    }

    public Cotizacion(/*Reparacion reparacion*/String descripcion_cotizacion, Float precioTotal, Date fechaVencimiento) {
        //this.reparacion = reparacion;
        this.descripcion_cotizacion = descripcion_cotizacion;
        this.precioTotal = precioTotal;
        this.fechaVencimiento = fechaVencimiento;
    }

    /*
    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }*/
    public String getDescripcion_cotizacion() {
        return descripcion_cotizacion;
    }

    public void setDescripcion_cotizacion(String descripcion_cotizacion) {
        this.descripcion_cotizacion = descripcion_cotizacion;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
