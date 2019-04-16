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

    //EL NUMERO DE FACTURA USAMOS EL ID DEL ABSTRACTENTITY
    private Double totalVenta;

    @ManyToOne
    @JoinColumn(name = "codCliente")
    private AbstractPersona codCliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFactura")
    private List<DetalleFactura> detalle_facturas;

    public Factura() {
    }

    public Factura(Long numeroFactura, Double totalVenta, Cliente codCliente) {
        this.totalVenta = totalVenta;
        this.codCliente = codCliente;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public AbstractPersona getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public List<DetalleFactura> getDetalle_facturas() {
        return detalle_facturas;
    }

    public void setDetalle_facturas(List<DetalleFactura> detalle_facturas) {
        this.detalle_facturas = detalle_facturas;
    }
}
