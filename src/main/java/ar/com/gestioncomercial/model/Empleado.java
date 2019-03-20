package ar.com.gestioncomercial.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("empleado_id")
public class Empleado extends AbstractPersona {

    private Float porcentajeComision;

    private Float sueldoBase;

    public Empleado() {

    }

    public Empleado(Float porcentajeComision, Float sueldoBase) {
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
    }

    public Empleado(Float porcentajeComision, Float sueldoBase, String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular) {
        super(nombre, telefono, mail, direccion, cuitCuil, observaciones, celular);
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
    }

    public Float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(Float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public Float getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Float sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

}
