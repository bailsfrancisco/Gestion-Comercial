package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("proveedor_id")
@NamedQueries({
    @NamedQuery(
            name = "proveedor.getAllProveedores",
            query = "select p from Proveedor p")
})
public class Proveedor extends AbstractPersona {

    @ManyToMany
    @JoinTable(name = "categoria_proveedor",
            joinColumns = @JoinColumn(name = "proveedor_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    @ManyToMany
    @JoinTable(name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "proveedor_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    private String razonSocial;

    private Integer calificacion;

    @Enumerated(EnumType.STRING)
    private CategoriaIVA categoriaIVA;

    private double retencionIva;

    private String cuentaContable;

    private String cbu;

    public Proveedor() {

    }

    public Proveedor(String razonSocial, Integer calificacion, CategoriaIVA categoriaIVA, double retencionIva, String cuentaContable, String cbu) {
        this.razonSocial = razonSocial;
        this.calificacion = calificacion;
        this.categoriaIVA = categoriaIVA;
        this.retencionIva = retencionIva;
        this.cuentaContable = cuentaContable;
        this.cbu = cbu;
    }

    public Proveedor(Categoria categoria, String razonSocial, Integer calificacion, CategoriaIVA categoriaIVA, double retencionIva, String cuentaContable, String cbu, String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular) {
        super(nombre, telefono, mail, direccion, cuitCuil, observaciones, celular);
        this.razonSocial = razonSocial;
        this.calificacion = calificacion;
        this.categoriaIVA = categoriaIVA;
        this.retencionIva = retencionIva;
        this.cuentaContable = cuentaContable;
        this.cbu = cbu;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    public CategoriaIVA getCategoriaIVA() {
        return categoriaIVA;
    }

    public void setCategoriaIVA(CategoriaIVA categoriaIVA) {
        this.categoriaIVA = categoriaIVA;
    }

    public double getRetencionIva() {
        return retencionIva;
    }

    public void setRetencionIva(double retencionIva) {
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

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
}
