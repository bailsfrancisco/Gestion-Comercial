package ar.com.gestioncomercial.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("cliente_id")
@NamedQueries({
    @NamedQuery(
            name = "cliente.getAllClientes",
            query = "select c from Cliente c")
})
public class Cliente extends AbstractPersona {

    @Enumerated(EnumType.STRING)
    private CategoriaIVA categoriaIVA;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Reparacion> reparaciones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<SolicitudReparacion> solicitudReparaciones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Factura> facturas_cliente;

    public Cliente() {

    }

    public Cliente(CategoriaIVA categoriaIVA, List<Reparacion> reparaciones, List<SolicitudReparacion> solicitudReparaciones, List<Factura> facturas_cliente) {
        this.categoriaIVA = categoriaIVA;
        this.reparaciones = reparaciones;
        this.solicitudReparaciones = solicitudReparaciones;
        this.facturas_cliente = facturas_cliente;
    }

    public Cliente(CategoriaIVA categoriaIVA, List<Reparacion> reparaciones, List<SolicitudReparacion> solicitudReparaciones, String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular, List<Factura> facturas_cliente) {
        super(nombre, telefono, mail, direccion, cuitCuil, observaciones, celular);
        this.categoriaIVA = categoriaIVA;
        this.reparaciones = reparaciones;
        this.solicitudReparaciones = solicitudReparaciones;
        this.facturas_cliente = facturas_cliente;
    }

    public CategoriaIVA getCategoriaIVA() {
        return categoriaIVA;
    }

    public void setCategoriaIVA(CategoriaIVA categoriaIVA) {
        this.categoriaIVA = categoriaIVA;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public List<SolicitudReparacion> getSolicitudReparaciones() {
        return solicitudReparaciones;
    }

    public void setSolicitudReparaciones(List<SolicitudReparacion> solicitudReparaciones) {
        this.solicitudReparaciones = solicitudReparaciones;
    }

    public List<Factura> getFacturas_cliente() {
        return facturas_cliente;
    }

    public void setFacturas_cliente(List<Factura> facturas_cliente) {
        this.facturas_cliente = facturas_cliente;
    }
}
