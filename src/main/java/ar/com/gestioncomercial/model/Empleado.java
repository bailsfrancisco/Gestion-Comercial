package ar.com.gestioncomercial.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    private Float porcentajeComision;

    private Float sueldoBase;
    /*
    @ManyToMany
    @JoinTable(name = "reparacion_tecnico",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "reparacion_id")
    )
    private List<Reparacion> reparaciones;
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecnico")
    private List<Reparacion> reparaciones;

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
