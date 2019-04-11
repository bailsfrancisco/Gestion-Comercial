/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.model;

/**
 *
 * @author bailsfrancisco
 */
public enum CategoriaIVA {
    MONOTRIBUTISTA("Monotributista"),
    RESPONSABLE_INSCRIPTO("Responsable inscripto"),
    EXCENTO("Excento"),
    CONSUMIDOR_FINAL("Consumidor final");

    private final String categoriaIVA;

    CategoriaIVA(String categoria) {
        categoriaIVA = categoria;
    }

    public String getCategoriaIVA() {
        return categoriaIVA;
    }
}
