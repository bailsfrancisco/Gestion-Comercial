package ar.com.gestioncomercial.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("empleado_id")
@NamedQueries({
    @NamedQuery(
            name = "empleado.getAllEmpleados",
            query = "select e from Empleado e")
})
public class Empleado extends AbstractPersona {

    private Float porcentajeComision;

    private Float sueldoBase;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecnico")
    private List<Reparacion> reparaciones_empleado;

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

    public List<Reparacion> getReparaciones_empleado() {
        return reparaciones_empleado;
    }

    public void setReparaciones_empleado(List<Reparacion> reparaciones_empleado) {
        this.reparaciones_empleado = reparaciones_empleado;
    }
}
