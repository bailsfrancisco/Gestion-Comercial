package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
import javax.persistence.Table;
//  CATEGORIAS PARA FILTRAN EN BUSQUEDA PRODUCTOS Y PROVEEDORES

@Entity
@Table(name = "categoria")
public class Categoria extends AbstractEntity {

    private String nombre;

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
}
