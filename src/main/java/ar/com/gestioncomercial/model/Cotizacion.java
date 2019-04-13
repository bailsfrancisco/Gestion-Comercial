package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cotizacion")
@NamedQueries({
    @NamedQuery(
            name = "cotizacion.getAll",
            query = "select c from Cotizacion c")
})
public class Cotizacion extends AbstractEntity {

    private String detalles;

    private double senia;

    private double precioManoObra;

    @OneToMany(cascade = CascadeType.DETACH)
    private List<Producto> insumos;

    // (precio insumos + comision empleado + precio base) - seña
    private double precioTotal;

    @OneToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_reparacion_id")
    private SolicitudReparacion solicitudReparacion;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    public Cotizacion() {

    }

    public Cotizacion(String detalle, double precioTotal, Date fechaVencimiento, SolicitudReparacion solicitudReparacion) {
        this.detalles = detalle;
        this.precioTotal = precioTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.solicitudReparacion = solicitudReparacion;
    }

    public SolicitudReparacion getSolicitudReparacion() {
        return solicitudReparacion;
    }

    public void setSenia(double senia) {
        this.senia = senia;
    }

    public void setPrecioManoObra(double precioManoObra) {
        this.precioManoObra = precioManoObra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
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

    public List<Producto> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Producto> insumos) {
        this.insumos = insumos;
    }

    public void addInsumo(Producto producto){
        this.insumos.add(producto);
    }

    public void removeInsumo(Producto producto){
        this.insumos.remove(producto);
    }

    public double getSenia() {
        return senia;
    }

    public double getPrecioManoObra() {
        return precioManoObra;
    }

    public void setSolicitudReparacion(SolicitudReparacion solicitudReparacion) {
        this.solicitudReparacion = solicitudReparacion;
    }

    public String cotizacionString(){
        return String.format("%s - %s", solicitudReparacion.getCliente(), solicitudReparacion.getMarca());
    }
}
