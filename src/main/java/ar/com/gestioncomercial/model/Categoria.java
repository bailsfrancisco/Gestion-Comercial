package ar.com.gestioncomercial.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//  CATEGORIAS PARA FILTRAN EN BUSQUEDA PRODUCTOS Y PROVEEDORES

@Entity
@Table(name = "categoria")
@NamedQueries({
    @NamedQuery(
            name = "categoria.getAll",
            query = "select c from Categoria c"),})
public class Categoria extends AbstractEntity {

    private String nombre;

    @ManyToMany
    @JoinTable(name = "categoria_proveedor",
            joinColumns = @JoinColumn(name = "proveedor_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Proveedor> proveedores;

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
