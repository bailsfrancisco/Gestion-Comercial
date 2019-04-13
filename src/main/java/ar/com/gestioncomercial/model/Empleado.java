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
            name = "empleado.getAll",
            query = "select e from Empleado e")
})
public class Empleado extends AbstractPersona {

    private double porcentajeComision;

    private double sueldoBase;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecnico")
    private List<Reparacion> reparaciones;

    public Empleado() {

    }

    public Empleado(double porcentajeComision, double sueldoBase) {
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
    }

    public Empleado(double porcentajeComision, double sueldoBase, String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular) {
        super(nombre, telefono, mail, direccion, cuitCuil, observaciones, celular);
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public void addReparacion(Reparacion reparacion) {
        this.reparaciones.add(reparacion);
    }
}
