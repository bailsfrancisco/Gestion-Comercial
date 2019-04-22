/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bailsfrancisco
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(
            name = "factura.getAll",
            query = "select f from Factura f"),})
public class Factura extends AbstractEntity {

    private String accesoriosIncluidos;

    //EL NUMERO DE FACTURA USAMOS EL ID DEL ABSTRACTENTITY
    private Double totalVenta;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private AbstractPersona cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFactura")
    private List<DetalleFactura> detalle_facturas;

    public Factura() {

    }

    public Factura(Double totalVenta, String accesoriosIncluidos, Cliente cliente) {
        this.totalVenta = totalVenta;
        this.accesoriosIncluidos = accesoriosIncluidos;
        this.cliente = cliente;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public AbstractPersona getCliente() {
        return cliente;
    }

    public void setCliente(AbstractPersona cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalle_facturas() {
        return detalle_facturas;
    }

    public void setDetalle_facturas(List<DetalleFactura> detalle_facturas) {
        this.detalle_facturas = detalle_facturas;
    }

    public String getAccesoriosIncluidos() {
        return accesoriosIncluidos;
    }

    public void setAccesoriosIncluidos(String accesoriosIncluidos) {
        this.accesoriosIncluidos = accesoriosIncluidos;
    }
}
