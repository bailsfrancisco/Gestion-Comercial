/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author bailsfrancisco
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(
            name = "detalle_factura.getAll",
            query = "select df from DetalleFactura df"),})
public class DetalleFactura extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "codFactura")
    private Factura codFactura;

    @ManyToOne
    @JoinColumn(name = "codProducto")
    private Producto codProducto;

    private String codigo;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioVenta;
    private Double total;

    public DetalleFactura() {

    }

    public DetalleFactura(Factura codFactura, Producto codProducto, String codigo, String nombreProducto, Integer cantidad, Double precioVenta, Double total) {
        this.codFactura = codFactura;
        this.codProducto = codProducto;
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.total = total;
    }

    public Factura getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Factura codFactura) {
        this.codFactura = codFactura;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodBarra() {
        return codigo;
    }

    public void setCodBarra(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
