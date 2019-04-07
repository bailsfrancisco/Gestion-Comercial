package ar.com.gestioncomercial.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(
            name = "producto.getAll",
            query = "select p from Producto p"),
})
public class Producto extends AbstractEntity {

    private String nombre;

    private String codigo;

    private String descripcion;

    private Float precioUnitario;

    private Integer stockMinimo;

    private Integer stockActual;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns= @JoinColumn(name = "proveedor_id")
    )
    private List<Proveedor> proveedores;

    public Producto() {

    }

    public Producto(String nombre, String codigo, String descripcion, Float precioUnitario, Integer stockMinimo, Integer stockActual, Categoria categoria, List<Proveedor> proveedores) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
        this.categoria = categoria;
        this.proveedores = proveedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
