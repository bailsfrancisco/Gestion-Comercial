package ar.com.gestioncomercial.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("proveedor_id")
public class Proveedor extends AbstractPersona {

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String razonSocial;

    private Integer calificacion;

    private String estado;

    private String condicionIva;

    private Float retencionIva;

    private String cuentaContable;

    private String cbu;

    public Proveedor() {

    }

    public Proveedor(Categoria categoria, String razonSocial, Integer calificacion, String estado, String condicionIva, Float retencionIva, String cuentaContable, String cbu) {
        this.categoria = categoria;
        this.razonSocial = razonSocial;
        this.calificacion = calificacion;
        this.estado = estado;
        this.condicionIva = condicionIva;
        this.retencionIva = retencionIva;
        this.cuentaContable = cuentaContable;
        this.cbu = cbu;
    }

    public Proveedor(Categoria categoria, String razonSocial, Integer calificacion, String estado, String condicionIva, Float retencionIva, String cuentaContable, String cbu, String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular) {
        super(nombre, telefono, mail, direccion, cuitCuil, observaciones, celular);
        this.categoria = categoria;
        this.razonSocial = razonSocial;
        this.calificacion = calificacion;
        this.estado = estado;
        this.condicionIva = condicionIva;
        this.retencionIva = retencionIva;
        this.cuentaContable = cuentaContable;
        this.cbu = cbu;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(String condicionIva) {
        this.condicionIva = condicionIva;
    }

    public Float getRetencionIva() {
        return retencionIva;
    }

    public void setRetencionIva(Float retencionIva) {
        this.retencionIva = retencionIva;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
}
