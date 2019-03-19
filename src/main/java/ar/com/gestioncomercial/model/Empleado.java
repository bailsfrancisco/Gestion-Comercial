package ar.com.gestioncomercial.model;

public class Empleado extends AbstractPersona {

    private Float porcentajeComision;

    public Float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(Float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
}
