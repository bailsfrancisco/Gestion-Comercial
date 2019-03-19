package ar.com.gestioncomercial.model;

import javax.persistence.Entity;
//  CATEGORIAS PARA FILTRAN EN BUSQUEDA PRODUCTOS Y PROVEEDORES
@Entity
public class Categoria extends AbstractEntity{

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
