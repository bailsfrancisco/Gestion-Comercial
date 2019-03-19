package ar.com.gestioncomercial.model;


import javax.persistence.Entity;

//TODO: AMPLIAR
@Entity
public class SolicitudReparacion extends AbstractEntity {

    private String descripcionFallo;

    private AbstractPersona cliente;

}
