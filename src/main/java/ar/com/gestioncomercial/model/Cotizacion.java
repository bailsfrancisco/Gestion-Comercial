package ar.com.gestioncomercial.model;

import java.util.Calendar;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;
    

    public Cotizacion() {

    }

    public Cotizacion(String detalle, Float precioTotal, Date fechaVencimiento) {
        this.detalles = detalle;
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
   //     Calendar calendar = Calendar.getInstance();
	
    //    calendar.setTime(fechaVencimiento); // Configuramos la fecha que se recibe
	
     /*   calendar.add(Calendar.DAY_OF_YEAR, 15);  // numero de dias a aniadir, o restar en caso de dias<0
        this.fechaVencimiento = calendar.getTime();//*/
        this.fechaVencimiento= fechaVencimiento;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}

