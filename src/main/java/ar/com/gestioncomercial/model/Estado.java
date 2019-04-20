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
public enum Estado {
    PENDIENTE("Pendiente"),
    EN_PROCESO("En proceso"),
    ENTREGADO("Entregado"),
    ANULADA("Anulada"),
    TERMINADO("Terminado");

    private final String estado;

    Estado(String e) {
        estado = e;
    }

    public String getEstadoString() {
        return estado;
    }
}
