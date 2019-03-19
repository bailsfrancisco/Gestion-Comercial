package ar.com.gestioncomercial.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends AbstractPersona {

    private Integer categoriaIVA;

    public Integer getCategoriaIVA() {
        return categoriaIVA;
    }

    public void setCategoriaIVA(Integer categoriaIVA) {
        this.categoriaIVA = categoriaIVA;
    }
}
