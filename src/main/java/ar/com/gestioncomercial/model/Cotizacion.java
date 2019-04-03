package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "cotizacion")
public class Cotizacion extends AbstractEntity {

    private String detalles;
    private Float precioTotal;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    public Cotizacion() {

    }

    public Cotizacion(Float precioTotal, Date fechaVencimiento) {
        this.precioTotal = precioTotal;
        this.fechaVencimiento = fechaVencimiento;
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

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
