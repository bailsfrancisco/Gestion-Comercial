package ar.com.gestioncomercial.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("cliente_id")
public class Cliente extends AbstractPersona {

    private Integer categoriaIVA;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Reparacion> reparaciones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<SolicitudReparacion> solicitudReparaciones;

    public Cliente() {

    }

    public Cliente(Integer categoriaIVA, List<Reparacion> reparaciones, List<SolicitudReparacion> solicitudReparaciones) {
        this.categoriaIVA = categoriaIVA;
        this.reparaciones = reparaciones;
        this.solicitudReparaciones = solicitudReparaciones;
    }

    public Cliente(Integer categoriaIVA, List<Reparacion> reparaciones, List<SolicitudReparacion> solicitudReparaciones, String nombre, String telefono, String mail, String direccion, String cuitCuil, String observaciones, String celular) {
        super(nombre, telefono, mail, direccion, cuitCuil, observaciones, celular);
        this.categoriaIVA = categoriaIVA;
        this.reparaciones = reparaciones;
        this.solicitudReparaciones = solicitudReparaciones;
    }

    public Integer getCategoriaIVA() {
        return categoriaIVA;
    }

    public void setCategoriaIVA(Integer categoriaIVA) {
        this.categoriaIVA = categoriaIVA;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public List<SolicitudReparacion> getSolicitudReparaciones() {
        return solicitudReparaciones;
    }

    public void setSolicitudReparaciones(List<SolicitudReparacion> solicitudReparaciones) {
        this.solicitudReparaciones = solicitudReparaciones;
    }
}
