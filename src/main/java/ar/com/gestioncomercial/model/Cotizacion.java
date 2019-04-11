package ar.com.gestioncomercial.model;

import java.util.Calendar;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "cotizacion")
@NamedQueries({
    @NamedQuery(
            name = "cotizacion.getAll",
            query = "select c from Cotizacion c")
})
public class Cotizacion extends AbstractEntity {

    private String detalles;
    private Float precioTotal;

    @OneToOne(optional = false)
    @JoinColumn(name = "solicitud_reparacion_id")
    private SolicitudReparacion solicitud_reparacion_id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    public Cotizacion() {

    }

    public Cotizacion(String detalle, Float precioTotal, Date fechaVencimiento, SolicitudReparacion solicitudReparacion) {
        this.detalles = detalle;
        this.precioTotal = precioTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.solicitud_reparacion_id = solicitudReparacion;
    }

    public SolicitudReparacion getSolicitud_reparacion_id() {
        return solicitud_reparacion_id;
    }

    public void setSolicitud_reparacion_id(SolicitudReparacion solicitud_reparacion_id) {
        this.solicitud_reparacion_id = solicitud_reparacion_id;
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
        //     Calendar calendar = Calendar.getInstance();

        //    calendar.setTime(fechaVencimiento); // Configuramos la fecha que se recibe
        /*   calendar.add(Calendar.DAY_OF_YEAR, 15);  // numero de dias a aniadir, o restar en caso de dias<0
        this.fechaVencimiento = calendar.getTime();//*/
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
